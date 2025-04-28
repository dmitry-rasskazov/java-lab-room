package com.company.timus;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MobileTelegraph
{
    private static BufferedReader reader;

    private static BufferedWriter writer;

    private static int[] times;

    private static Node firstNumber;

    private static Node lastNumber;

    public static void main(String[] args) throws IOException
    {
        initEn();

        int n = Integer.parseInt(new String(nextNumber(), StandardCharsets.UTF_8));
        Map<ByteArrayKey, Node> map = new HashMap<>(n);

        times = nextNumberList();

        byte[] number = nextNumber();

        Node node = new Node(1, number);
        node.setTime(0);

        firstNumber = node;
        map.put(new ByteArrayKey(number), node);

        for(int i = 2; i <= n; i++) {
            number = nextNumber();
            node = new Node(i, number);
            insertToMap(node, map);
        }

        lastNumber = node;

        if(search()) {
            writer.write(Integer.toString(lastNumber.getTime()));
            writer.newLine();
            node = lastNumber;
            Stack<Node> steps = new Stack<>();
            steps.add(node);

            while((node = node.getParent()) != null) {
                steps.add(node);
            }

            writer.write(Integer.toString(steps.size()));
            writer.newLine();
            writer.write(Integer.toString(steps.pop().getId()));
            while(!steps.empty()) {
                writer.write(" ");
                writer.write(Integer.toString(steps.pop().getId()));
            }

            writer.newLine();
            writer.flush();
        } else {
            System.out.println("-1");
        }
    }

    private static boolean search()
    {
        Queue<Node> queue = new PriorityQueue<>();

        Node node;
        int timeIndex;
        int time, oldTime;

        if(lastNumber.getNeighbours().isEmpty()) {
            return false;
        }

        queue.add(firstNumber);

        while (!queue.isEmpty()) {
            node = queue.poll();

            if(lastNumber.getTime() < node.getTime()) {
                continue;
            }

            for(Node neighbour: node.getNeighbours()) {
                if(!neighbour.isVisited()) {
                    timeIndex = getCommonHeaderLength(node.getNumber(), neighbour.getNumber());

                    time = times[timeIndex] + node.getTime();

                    oldTime = neighbour.getTime();
                    if(time < oldTime) {
                        neighbour.setTime(time);
                        neighbour.setParent(node);

                        if(lastNumber.equals(neighbour)) {
                            lastNumber.getNeighbours().remove(node);
                            if(lastNumber.getNeighbours().isEmpty()) {
                                return true;
                            }

                            continue;
                        }

                        queue.add(neighbour);
                    }
                }
            }

            node.setVisited(true);
        }

        return lastNumber.getParent() != null;
    }

    private static void initEn() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static byte[] nextNumber() throws IOException {
        return reader.readLine().getBytes();
    }

    private static int[] nextNumberList() throws IOException {
        String[] splitNumbers = reader.readLine().split(" ");
        int[] result = new int[splitNumbers.length];

        for (int i = 0; i < splitNumbers.length; i++) {
            result[i] = Integer.parseInt(splitNumbers[i]);
        }

        return result;
    }

    private static int getCommonHeaderLength(byte[] first, byte[] second)
    {
        for(int i = 0; i < first.length; i++)
        {
            if(first[i] != second[i]) {
                return i;
            }
        }

        return -1;
    }

    private static void insertToMap(Node node, Map<ByteArrayKey, Node> map)
    {
        byte[] source = node.getNumber();
        Node neighbour;
        byte[] neighbourNumber;

        for(int i = 0; i < source.length; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(source[i] == j + '0') {
                    continue;
                }

                neighbourNumber = new byte[source.length];
                System.arraycopy(source, 0, neighbourNumber, 0, source.length);
                neighbourNumber[i] = (byte) (j + '0');

                if((neighbour = map.get(new ByteArrayKey(neighbourNumber))) != null) {
                    node.addNeighbour(neighbour);
                    neighbour.addNeighbour(node);
                }
            }

            for(int j = i+1; j < source.length; j++)
            {
                if(source[j] == source[i]) {
                    continue;
                }

                neighbourNumber = new byte[source.length];
                System.arraycopy(source, 0, neighbourNumber, 0, source.length);
                byte temp = neighbourNumber[i];
                neighbourNumber[i] = neighbourNumber[j];
                neighbourNumber[j] = temp;

                if((neighbour = map.get(new ByteArrayKey(neighbourNumber))) != null) {
                    node.addNeighbour(neighbour);
                    neighbour.addNeighbour(node);
                }
            }
        }

        ByteArrayKey key = new ByteArrayKey(node.getNumber());
        map.put(key, node);
    }

    private static class Node implements Comparable<Node>
    {
        private final int id;
        private final byte[] number;
        private final List<Node> neighbours;
        private int time;
        private boolean visited;
        private Node parent;

        Node(int id, byte[] number)
        {
            this.id = id;
            this.number = number;
            this.neighbours = new LinkedList<>();
            this.time = Integer.MAX_VALUE;
        }

        public int getId() {
            return this.id;
        }

        public byte[] getNumber() {
            return this.number;
        }

        public List<Node> getNeighbours() {
            return this.neighbours;
        }

        public void addNeighbour(Node node)
        {
            this.neighbours.add(node);
        }

        public void setTime(int time)
        {
            this.time = time;
        }

        public int getTime()
        {
            return this.time;
        }

        public boolean isVisited()
        {
            return this.visited;
        }

        public void setVisited(boolean visited)
        {
            this.visited = visited;
        }

        public void setParent(Node parent)
        {
            this.parent = parent;
        }

        public Node getParent()
        {
            return this.parent;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null || Node.class != obj.getClass()) return false;
            Node node = (Node) obj;
            return id == node.id;
        }

        @Override
        public int compareTo(Node o)
        {
            return Integer.compare(this.time, o.getTime());
        }
    }

    private static class ByteArrayKey
    {
        private final int hash;

        private final byte[] array;

        public ByteArrayKey(byte[] array)
        {
            this.hash = Arrays.hashCode(array);
            this.array = array;
        }

        public byte[] getArray()
        {
            return this.array;
        }

        @Override
        public int hashCode()
        {
            return this.hash;
        }

        @Override
        public boolean equals(Object o)
        {
            return o instanceof ByteArrayKey && Arrays.equals(((ByteArrayKey) o).getArray(), this.array);
        }
    }
}
