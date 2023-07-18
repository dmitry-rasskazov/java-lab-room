package com.company.example;

import org.mobicents.protocols.api.*;
import org.mobicents.protocols.sctp.netty.NonPersistentNettySctpManagementImpl;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SCTPCongestionTest
{
    public static final String SERVER_ADDR = "127.0.0.1";

    public static final String CLIENT_ADDR = "127.0.0.1";

    public static final int SERVER_PORT = 7000;

    public static final int CLIENT_PORT = 6000;

    public static final String CLIENT_NAME = "CLIENT";

    public static final String SERVER_NAME = "SERVER";

    private static final Management sctpManagement;

    static {
        try {
            sctpManagement = new NonPersistentNettySctpManagementImpl("SCTP_MANAGEMENT");

            sctpManagement.setOptionSoRcvbuf(524288);
            sctpManagement.setOptionSoSndbuf(524288);

            sctpManagement.setWorkerThreads(20);

            sctpManagement.setBufferSize(524288);
            sctpManagement.start();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

        Association client = sctpManagement.addAssociation(
                CLIENT_ADDR,
                CLIENT_PORT,
                SERVER_ADDR,
                SERVER_PORT,
                CLIENT_NAME
        );

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

        AssociationWrapper serverPeer = new AssociationWrapper(server);
        AssociationWrapper clientPeer = new AssociationWrapper(client);

        sctpManagement.startAssociation(SERVER_NAME);
        sctpManagement.startAssociation(CLIENT_NAME);

        while(!server.isUp()) {
            Thread.sleep(10);
        }

        serverPeer.start();
        clientPeer.start();

        Thread.sleep(8200);

        clientPeer.stop();
        serverPeer.stop();

        sctpManagement.stopAssociation(CLIENT_NAME);
        sctpManagement.stopAssociation(SERVER_NAME);
        sctpManagement.stopServer(SERVER_NAME);

        System.out.printf(
                "Server received messages count: %d, client received messages count: %d",
                serverPeer.countOfMessages(),
                clientPeer.countOfMessages()
        );

        sctpManagement.stop();
    }

    private static class AssociationWrapper implements AssociationListener
    {
        private static final int M2PA_PROTOCOL_ID = 5;

        private final AtomicInteger countOfMessages;

        private final Association association;

        private final ScheduledExecutorService executorService;

        public AssociationWrapper(Association association)
        {
            this.countOfMessages = new AtomicInteger(0);
            this.association = association;
            this.association.setAssociationListener(this);
            this.executorService = Executors.newSingleThreadScheduledExecutor();
        }

        public void start()
        {
            System.out.println("Started");
            this.executorService.scheduleAtFixedRate(this::send, 0, 20, TimeUnit.MICROSECONDS);
        }

        @Override
        public void onCommunicationUp(Association association, int i, int i1)
        {
            System.out.println("onCommunicationUp on " + association.getName());
        }

        @Override
        public void onCommunicationShutdown(Association association)
        {
            System.out.println("onCommunicationShutdown on " + association.getName());
        }

        @Override
        public void onCommunicationLost(Association association)
        {
            System.out.println("onCommunicationLost on " + association.getName());
        }

        @Override
        public void onCommunicationRestart(Association association)
        {
            System.out.println("onCommunicationRestart on " + association.getName());
        }

        @Override
        public void onPayload(Association association, PayloadData payloadData)
        {
            this.countOfMessages.incrementAndGet();
            payloadData.getByteBuf();
        }

        @Override
        public void inValidStreamId(PayloadData payloadData)
        {
            System.out.println("inValidStreamId: " + payloadData.toString());
        }

        public void stop()
        {
            this.executorService.shutdown();
            System.out.println("Finished");
        }

        public int countOfMessages()
        {
            return this.countOfMessages.get();
        }

        private PayloadData createPayload(byte[] buffer, int streamId)
        {
            return new PayloadData(
                    buffer.length,
                    buffer,
                    true,
                    false,
                    M2PA_PROTOCOL_ID,
                    streamId
            );
        }

        private byte[][] generateMessagePacket(int packetSize)
        {
            byte[][] result = new byte[packetSize][255];
            for (int i = 0; i < packetSize; i++) {

                result[i] = this.generateMessage(255);
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

        private void send()
        {
            try {
                this.association.send(this.createPayload(this.generateMessage(255), 1));
            } catch (Exception ignored) {}
        }
    }
}
