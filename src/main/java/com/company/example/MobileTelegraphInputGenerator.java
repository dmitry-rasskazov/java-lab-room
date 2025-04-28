package com.company.example;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

public class MobileTelegraphInputGenerator
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1024);

    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 32768);

    public static void main(String[] args) throws IOException {
        Set<ByteArrayKey> set = new HashSet<>();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int n = Integer.parseInt(reader.readLine());
        AtomicReference<ByteArrayKey> seed = new AtomicReference<>(new ByteArrayKey(nextNumber()));

        while(set.size() < n)
        {
            byte[][] neighbors = generateNeighbours(seed.get().getArray());
            random.ints(0, neighbors.length)
                    .distinct()
                    .limit(neighbors.length)
                    .forEach(index -> {
                ByteArrayKey key = new ByteArrayKey(neighbors[index]);
                set.add(key);
                seed.set(new ByteArrayKey(neighbors[index]));
            });
        }

        writer.write(String.format("%d", n));
        writer.newLine();
        writer.write("10000 10000 1000 1000 100 100 10 10 1 1");
        writer.newLine();
        set.forEach(key -> {
            try {
                writer.write(key.toString());
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        writer.flush();
    }

    private static byte[][] generateNeighbours(byte[] source)
    {
        byte[][] neighbours = new byte[145][source.length];

        int index = 0;
        for(int i = 0; i < source.length; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(source[i] == j + '0') {
                    continue;
                }

                byte[] neighbour = source.clone();
                neighbour[i] = (byte) (j + '0');

                neighbours[index] = neighbour;
                index++;
            }
        }

        for(int i = 0; i < source.length; i++)
        {
            for(int j = i+1; j < source.length; j++)
            {
                byte[] neighbour = source.clone();
                byte temp = neighbour[i];
                neighbour[i] = neighbour[j];
                neighbour[j] = temp;
                neighbours[index] = neighbour;
                index++;
            }
        }

        neighbours = Arrays.copyOf(neighbours, index);

        return neighbours;
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
            return o instanceof MobileTelegraphInputGenerator.ByteArrayKey && Arrays.equals(((MobileTelegraphInputGenerator.ByteArrayKey) o).getArray(), this.array);
        }

        @Override
        public String toString()
        {
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : this.array)
            {
                stringBuilder.append((char) b);
            }

            return stringBuilder.toString();
        }
    }

    private static byte[] nextNumber() throws IOException {
        return reader.readLine().getBytes();
    }
}
