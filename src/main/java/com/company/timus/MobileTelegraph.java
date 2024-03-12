package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MobileTelegraph {
    private static BufferedReader console;
    private static int[] times;
    private static Node head;
    private static Map<String, Node> cache;

    public static void main(String[] args) throws IOException {
        initEn();

        int N = nextNumber();

        cache = new HashMap<>(N);

        times = nextNumberList();

        head = new Node(console.readLine(), 1, false);
        cache.put(head.telNumber(), head);

        Node nextNode;
        N--;
        for (int i = 2; i <= N; i++) {
            nextNode = new Node(console.readLine(), i, false);

//            fillNeighbours(nextNode);
        }

        nextNode = new Node(console.readLine(), ++N, true);
//        fillNeighbours(nextNode);

        cache = new HashMap<>(N);
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while (!stack.empty()) {
            nextNode = stack.pop();
            if(!nextNode.isTarget()) {
                for (Node item: nextNode.neighbours()) {
                    stack.push(item);
                }
            }
        }
    }

    private static String[] getNumbers(int length) throws IOException {
        String[] telNumbers = new String[length];

        for (int i = 0; i < telNumbers.length; i++) {
            telNumbers[i] = console.readLine();
        }

        return telNumbers;
    }

    private static void initEn() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    private static int nextNumber() throws IOException {
        return Integer.parseInt(console.readLine());
    }

    private static int[] nextNumberList() throws IOException {
        String[] splitNumbers = console.readLine().split(" ");
        int[] result = new int[splitNumbers.length];

        for (int i = 0; i < splitNumbers.length; i++) {
            result[i] = Integer.parseInt(splitNumbers[i]);
        }

        return result;
    }

    private static boolean isSimilar(String first, String second) 
    {
        char[] exchange = new char[2];
        short diffCounter = 0;

        for(int i = 0; i < first.length(); i++)
        {
            if(first.charAt(i) != second.charAt(i)) {
                if(diffCounter == 0) {
                    ++diffCounter;
                    exchange[0] = first.charAt(i);
                    exchange[1] = second.charAt(i);
                } else if (diffCounter == 1 && (exchange[0] != second.charAt(i) || exchange[1] != first.charAt(i))) {
                    return false;
                } else {
                    ++diffCounter;
                }
            }
        }

        return diffCounter <= 2;
    }

    private static int getTime(String first, String second) {
        return times[getPrefixLength(first, second)];
    }

    private static int getPrefixLength(String first, String second) {
        if(first.length() != second.length()) {
            return 0;
        }

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        for(int i = 0; i < firstArray.length; i++) {
            if(firstArray[i] != secondArray[i]) {
                return i;
            }
        }

        return firstArray.length-1;
    }
}

class Node {
    private final String telNumber;
    private final int orderNumber;
    private final List<Node> neighbours;
    private final boolean isTarget;

    public Node(String telNumber, int orderNumber, boolean isTarget)
    {
        this.telNumber = telNumber;
        this.orderNumber = orderNumber;
        this.neighbours = new ArrayList<>();
        this.isTarget = isTarget;
    }

    public List<Node> neighbours()
    {
        return this.neighbours;
    }

    public String telNumber()
    {
        return this.telNumber;
    }

    public int orderNumber()
    {
        return this.orderNumber;
    }

    public boolean isTarget()
    {
        return this.isTarget;
    }

    public boolean equals(Node node)
    {
        return this.telNumber().equals(node.telNumber());
    }

    public int hashCode()
    {
        return this.telNumber().hashCode();
    }
}
