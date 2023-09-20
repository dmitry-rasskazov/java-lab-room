package com.company.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import org.mobicents.protocols.api.*;
import org.mobicents.protocols.sctp.netty.NonPersistentNettySctpManagementImpl;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SCTPCongestionTest
{
    public static final String SERVER_ADDR = "127.0.0.1";

    public static final String CLIENT_ADDR = "127.0.0.1";

    public static final int SERVER_PORT = 7000;

    public static final int CLIENT_PORT = 6000;

    public static final String CLIENT_NAME = "CLIENT";

    public static final String SERVER_NAME = "SERVER";

    private static final Management sctpManagement;

    private static volatile boolean started = true;

    static {
        try {
            sctpManagement = new NonPersistentNettySctpManagementImpl("SCTP_MANAGEMENT");
            sctpManagement.setWorkerThreads(20);

            sctpManagement.start();

            sctpManagement.setOptionSctpNodelay(true);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

        sctpManagement.addCongestionListener(new AssociationCongestionListener());

        sctpManagement.addServer(
                SERVER_NAME,
                SERVER_ADDR,
                SERVER_PORT
        );

        sctpManagement.startServer(SERVER_NAME);

        Association server = sctpManagement.addServerAssociation(
                CLIENT_ADDR,
                CLIENT_PORT,
                SERVER_NAME,
                SERVER_NAME,
                IpChannelType.SCTP
        );

        Association client = sctpManagement.addAssociation(
                CLIENT_ADDR,
                CLIENT_PORT,
                SERVER_ADDR,
                SERVER_PORT,
                CLIENT_NAME
        );

        AssociationTrafficGenerator serverPeer = new AssociationTrafficGenerator(server);
        AssociationTrafficGenerator clientPeer = new AssociationTrafficGenerator(client);

        sctpManagement.startAssociation(CLIENT_NAME);
        sctpManagement.startAssociation(SERVER_NAME);

        while(!server.isUp()) {
            Thread.sleep(100);
        }

        serverPeer.start();
        clientPeer.start();

        waitForShutdown();

        clientPeer.stop();
        serverPeer.stop();

        sctpManagement.stopAssociation(CLIENT_NAME);
        sctpManagement.stopAssociation(SERVER_NAME);
        sctpManagement.stopServer(SERVER_NAME);

        System.out.println(new StringBuilder()
                .append("Server received messages count: %d, client received messages count: %d")
                .append(serverPeer.countOfMessages())
                .append(clientPeer.countOfMessages())
        );

        sctpManagement.stop();
    }

    private static void waitForShutdown() throws InterruptedException
    {
        Thread shutdownHook = new Thread(new ShutdownHandler());
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        while(started)
        {
            Thread.sleep(1000);
        }
    }

    private static class AssociationTrafficGenerator implements AssociationListener, Runnable
    {
        private static final int M2PA_PROTOCOL_ID = 5;

        private final AtomicBoolean started;

        private final AtomicInteger countOfReceivedMessages;

        private final AtomicInteger countOfTransmittedMessages;

        private final Association association;

        private final Lock eventMutex;

        private final long startTime;

        private final ExecutorService cleanExecutorsPool;

        private int packetSize;

        private ScheduledExecutorService generateExecutor;

        public AssociationTrafficGenerator(Association association)
        {
            this.countOfReceivedMessages = new AtomicInteger(0);
            this.countOfTransmittedMessages = new AtomicInteger(0);
            this.started = new AtomicBoolean(false);
            this.association = association;
            this.association.setAssociationListener(this);
            this.generateExecutor = this.createScheduledExecutor();
            this.cleanExecutorsPool = Executors.newFixedThreadPool(1);
            this.eventMutex = new ReentrantLock();
            this.packetSize = 0;
            this.startTime = System.currentTimeMillis() / 1000;
        }

        public void start()
        {
            this.eventMutex.lock();

            this.started.set(true);
            this.printlnNotify("Started");

            this.eventMutex.unlock();
        }

        public void stop()
        {
            this.eventMutex.lock();

            this.started.set(false);
            this.printlnNotify("Finished");

            this.eventMutex.unlock();
        }

        public int countOfMessages()
        {
            return this.countOfReceivedMessages.get();
        }

        @Override
        public void run()
        {
            if(this.started.get()) {
                this.packetSize = this.packetSize < 5000 ? this.packetSize + 10 : 5000;
                for(byte[] message: this.generateMessagePacket(packetSize)) {
                    this.send(this.createPayload(message, 1));
                }
            }

            this.doGenerate();
        }

        @Override
        public void onCommunicationUp(Association association, int i, int i1)
        {
            this.printlnNotify("onCommunicationUp");
            this.doGenerate();
        }

        @Override
        public void onCommunicationShutdown(Association association)
        {
            this.printlnNotify("onCommunicationShutdown");
            this.generateExecutor.shutdown();
        }

        @Override
        public void onCommunicationLost(Association association)
        {
            this.printlnNotify("onCommunicationLost");
            this.generateExecutor.shutdown();
        }

        @Override
        public void onCommunicationRestart(Association association)
        {
            this.printlnNotify("onCommunicationRestart");
            this.generateExecutor.shutdown();
        }

        @Override
        public void onPayload(Association association, PayloadData payloadData)
        {
            ByteBuf byteBuf = payloadData.getByteBuf();
            ReferenceCountUtil.release(byteBuf, byteBuf.refCnt());

            this.cleanExecutorsPool.execute(this::calculateMessages);
        }

        @Override
        public void inValidStreamId(PayloadData payloadData)
        {
            this.printlnNotify("inValidStreamId");
        }

        protected void printlnNotify(String message)
        {
            System.out.println(new StringBuilder().append(this.association.getName()).append(": ").append(message));
        }

        private PayloadData createPayload(byte[] buffer, int streamId)
        {
            try {
                ByteBuf byteBuf;
                byteBuf = Unpooled.buffer();

                byteBuf.writeBytes(buffer);

                return new PayloadData(
                        byteBuf.readableBytes(),
                        byteBuf,
                        true,
                        false,
                        M2PA_PROTOCOL_ID,
                        streamId
                );
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }

        private byte[][] generateMessagePacket(int packetSize)
        {
            if(packetSize < 1) {
                return new byte[0][0];
            }

            byte[][] result = new byte[packetSize][100];
            for (int i = 0; i < packetSize; i++) {

                result[i] = this.generateMessage(100);
            }
            return result;
        }

        private byte[] generateMessage(int countBytes)
        {
            Random rand = new Random();
            int seed = rand.nextInt();

            byte[] result = new byte[countBytes];

            for (int i = 0; i < countBytes; i++) {
                result[i] = (byte) (seed % 255);
            }

            return result;
        }

        private void send(PayloadData payload)
        {
            if(this.association.isUp()) {
                try {
                    this.association.send(payload);
                    this.countOfTransmittedMessages.incrementAndGet();
                } catch (Exception exception) {
                    this.printlnNotify(exception.getMessage());
                    exception.printStackTrace();
                    this.generateExecutor.shutdown();
                }
            }
        }

        private ScheduledExecutorService createScheduledExecutor()
        {
            return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread newThread = new Thread(r);
                    newThread.setName(AssociationTrafficGenerator.this.association.getName() + "-Traffic-Generator");
                    return newThread;
                }
            });
        }

        private void doGenerate()
        {
            if(this.generateExecutor.isShutdown()) {
                this.generateExecutor = this.createScheduledExecutor();
            }

            this.generateExecutor.schedule(this, 100, TimeUnit.MILLISECONDS);
        }

        private void calculateMessages()
        {
            int countReceived;
            if((countReceived = this.countOfReceivedMessages.incrementAndGet()) % 1000000 == 0)
            {
                this.printlnNotify(new StringBuilder()
                        .append("current received count: ")
                        .append(countReceived)
                        .append(". Current transmitted count: ")
                        .append(this.countOfTransmittedMessages.get())
                        .append(". Time: ")
                        .append(System.currentTimeMillis() / 1000 - this.startTime)
                        .toString()
                );
            }
        }

        private void downSizePacket()
        {
            this.packetSize >>= 1;
        }
    }

    private static class ShutdownHandler implements Runnable
    {
        @Override
        public void run()
        {
            SCTPCongestionTest.started = false;
        }
    }

    private static class AssociationCongestionListener implements CongestionListener
    {
        @Override
        public void onCongLevelChanged(Association association, int prevCongestionLevel, int currentCongestionLevel)
        {
            AssociationListener associationListener = association.getAssociationListener();

            if(!AssociationTrafficGenerator.class.equals(associationListener.getClass()) || currentCongestionLevel == prevCongestionLevel) {
                return;
            }

            AssociationTrafficGenerator associationTrafficGenerator = (AssociationTrafficGenerator) associationListener;

            associationTrafficGenerator.printlnNotify(
                    new StringBuilder()
                            .append("congestion level changed from ")
                            .append(prevCongestionLevel)
                            .append(" to ")
                            .append(currentCongestionLevel)
                            .append("!")
                            .toString()
                    );

            if(prevCongestionLevel < currentCongestionLevel) {
                this.onCongestionLevelDown(associationTrafficGenerator);
            } else if(0 == currentCongestionLevel) {
                this.onCongestionLevelUp(associationTrafficGenerator);
            }

            associationTrafficGenerator.printlnNotify(String.format(
                    "association writebuff size: %d, readbuff size: %d"
            ));
        }

        private void onCongestionLevelDown(AssociationTrafficGenerator associationTrafficGenerator)
        {
            System.gc();
            associationTrafficGenerator.stop();
            associationTrafficGenerator.downSizePacket();
        }

        private void onCongestionLevelUp(AssociationTrafficGenerator associationTrafficGenerator)
        {
            associationTrafficGenerator.start();
        }
    }
}
