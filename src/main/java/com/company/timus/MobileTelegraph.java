package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MobileTelegraph {
    private static BufferedReader console;
    private static int[] times;
    private static Map<String, Node> graphCache;
    private static final int ORDER = 0;
    private static final int TIME = 1;

    public static void main(String[] args) throws IOException {
        initEn();

        int count = nextNumber();
        times = nextNumberList();
        String[] telNumbers = getNumbers(count);

//        Node graph = createGraph(0, telNumbers, 0); // старая реализация

        Map<String, Map<String, int[]>> graph = createGraph(telNumbers);
//        graph.forEach((key, item) -> System.out.println(key + " " + item.size())); // вывести статистику по графу


        List<String> resultList = new LinkedList<>();
//
//        showGraph(graph, 0);

//        int time = traversalGraph(graph, telNumbers, resultList);



//        if(resultList.size() == 0 || time < 0) {
//            System.out.println("-1");
//            return;
//        }
//
//        System.out.println(time);
//        System.out.println(resultList.size());
//
//        for (Node result: resultList) {
//            System.out.print(result.orderNumber() + " ");
//        }
    }

    private static int traversalGraph(Map<String, Map<String, int[]>> graph, String[] telNumbers, List<String> list) {
        Stack<String> stack = new Stack<>();
        stack.push(telNumbers[0]);
        int time = 0;

        for(Map<String, int[]> item = graph.get(stack.pop()); item != null; item = graph.get(stack.pop())) {

        }

        return time;
    }
//    private static int traversalGraph(Node head, List<Node> list) {
//        if(!head.isDeadlock()) {
//            list.add(head);
//            int minTime = -1;
//            List<Node> results = null;
//
//            for (Node node: head.children()) {
//                List<Node> bufferResults = new LinkedList<>();
//                int bufferTime = traversalGraph(node, bufferResults);
//                if(bufferTime == -1) continue;
//                minTime = Math.min(bufferTime, minTime == -1 ? bufferTime : minTime);
//                if(minTime == bufferTime) {
//                    results = bufferResults;
//                }
//            }
//
//            if(null != results) {
//                list.addAll(results);
//            }
//
//            return head.time() + (minTime == -1 ? 0 : minTime);
//        }
//
//        return -1;
//    }

    private static void showGraph(Node head, int idt) {
        if(!head.isDeadlock()) {
            for(int i = 0; i < idt; i++) {
                System.out.print("\t");
            }
            System.out.println(head.telNumber());
            for (Node node: head.children()) {
                showGraph(node, idt+1);
            }
        }
    }

    private static Map<String, Map<String, int[]>> createGraph(String[] telNumbers) {
        Map<String, Map<String, int[]>> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(Integer i = stack.pop(); i != null; ) {
            Map<String, int[]> children = new HashMap<>();
            for(int j = 0; j < telNumbers.length; ++j) {
                if(isSimilar(telNumbers[i], telNumbers[j]) && (result.get(telNumbers[j]) == null || result.get(telNumbers[j]).get(telNumbers[i]) == null)) {
                    children.put(telNumbers[j], new int[]{j+1, getTime(telNumbers[i], telNumbers[j])});
                    if(!stack.contains(j)) {
                        stack.push(j);
                    }
                }
            }
            if(children.size() > 0) {
                result.put(telNumbers[i], children);
            }

            try {i = stack.pop();} catch (EmptyStackException e) {i = null;}
        }

        return result;
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
        graphCache = new HashMap<>();
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

    private static boolean isSimilar(String first, String second) {
        if(first.length() != second.length() || first.equals(second)) {
            return false;
        }

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
    private boolean isEnd;
    private boolean isTargetNode;
    private final List<Node> children;
    private final int time;
    private int expectedChildren;

    public Node(String telNumber, int orderNumber, int time) {
        this.isEnd = false;
        this.telNumber = telNumber;
        this.orderNumber = orderNumber;
        this.isTargetNode = false;
        this.time = time;
        this.children = new ArrayList<>();
        this.expectedChildren = 0;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public List<Node> children() {
        return this.children;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void setIsTargetNode(boolean isTargetNode) {
        this.isTargetNode = isTargetNode;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public boolean isTargetNode() {
        return this.isTargetNode;
    }

    public String telNumber() {
        return this.telNumber;
    }

    public int orderNumber() {
        return this.orderNumber;
    }

    public boolean isDeadlock() {
        return this.isEnd && !this.isTargetNode;
    }

    public int time() {
        return this.time;
    }

    public boolean equals(Node node) {
        return this.telNumber().equals(node.telNumber());
    }

    public int hashCode() {
        return this.telNumber().hashCode();
    }

    public boolean isFilledChildren() {
        return this.expectedChildren == children.size();
    }

    public void incrementExpectedChildren() {
        this.expectedChildren = this.expectedChildren+1;
    }
}
