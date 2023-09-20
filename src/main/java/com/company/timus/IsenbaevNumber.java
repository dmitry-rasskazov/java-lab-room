package com.company.timus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IsenbaevNumber {
    private static final InputStream inputStream = new BufferedInputStream(System.in, 1024);

    private static final String ISENBAEV = "Isenbaev";

    public static void main(String[] args) {
        Scanner console = new Scanner(inputStream);
        int N = nextInt();
        Map<String, Node> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            String name1;
            Node member1;
            name1 = console.next();
            if(null == (member1 = map.get(name1))) {
                member1 = new Node(name1);
                map.put(name1, member1);
            }

            String name2;
            Node member2;
            name2 = console.next();
            if(null == (member2 = map.get(name2))) {
                member2 = new Node(name2);
                map.put(name2, member2);
            }

            String name3;
            Node member3;
            name3 = console.next();
            if(null == (member3 = map.get(name3))) {
                member3 = new Node(name3);
                map.put(name3, member3);
            }

            member1.addNeighbours(member2, member3);
            member2.addNeighbours(member1, member3);
            member3.addNeighbours(member2, member1);

            console.nextLine();
        }

        List<Node> queue = new ArrayList<>(map.size());
        Set<Node> neighbours = new HashSet<>(map.size());
        Node isenbaev = map.get(ISENBAEV);
        if(null != isenbaev) {
            queue.add(isenbaev);
        }

        int nextIsenbaevNumber;

        for(int i = 0; i < queue.size(); i++)
        {
            Node current = queue.get(i);

            List<Node> filteredNeighbours = current.neighbours().stream().filter((item) -> !neighbours.contains(item)).collect(Collectors.toList());
            neighbours.addAll(filteredNeighbours);
            queue.addAll(filteredNeighbours);

            nextIsenbaevNumber = current.isenbaevNumber() + 1;
            for(Node neighbour: filteredNeighbours)
            {
                if(-1 == neighbour.isenbaevNumber()) {
                    neighbour.setIsenbaevNumber(nextIsenbaevNumber);
                }
            }
        }

        int isenbaevNumber;
        for(Node item: map.values())
        {
            isenbaevNumber = item.isenbaevNumber();
            System.out.println(String.format("%s %s", item.name(), -1 == isenbaevNumber ? "undefined" : isenbaevNumber));
        }
    }

    private static int nextInt() {
        int result = 0;
        int buf;
        boolean captured = false;
        try {
            while ((buf = inputStream.read()) != -1) {
                if(buf >= '0' && buf <= '9') {
                    captured = true;
                    result = ((result * 10) + (buf - '0'));
                } else if(captured && (buf == ' ' || buf == '\n')) {
                    break;
                }
            }
        } catch (IOException ignored) {

        }

        return result;
    }

    private static class Node implements Comparable<Node>
    {
        private final String name;

        private int isenbaevNumber;

        private final Set<Node> neighbours;

        public Node(String name)
        {
            this.name = name;
            this.isenbaevNumber = ISENBAEV.equals(name) ? 0 : -1;
            this.neighbours = new TreeSet<>();
        }

        public String name()
        {
            return this.name;
        }

        public void setIsenbaevNumber(int isenbaevNumber)
        {
            this.isenbaevNumber = isenbaevNumber;
        }

        public int isenbaevNumber()
        {
            return this.isenbaevNumber;
        }

        public void addNeighbour(Node neighbour)
        {
            if(this.name.equals(neighbour.name())) return;
            this.neighbours.add(neighbour);
        }

        public void addNeighbours(Node ...neighbours)
        {
            for (Node item: neighbours)
            {
                this.addNeighbour(item);
            }
        }

        public Collection<Node> neighbours()
        {
            return this.neighbours;
        }

        @Override
        public int compareTo(Node target) {
            return this.name().compareTo(target.name());
        }
    }
}


/**
 * 1837. Число Исенбаева
 * Ограничение времени: 0.5 секунды
 * Ограничение памяти: 64 МБ
 * Владислав Исенбаев — двукратный чемпион Урала по программированию, вице-чемпион TopCoder Open 2009, абсолютный чемпион ACM ICPC 2009. За то время, которое вы потратите на чтение этого условия, Владислав уже решил бы одну задачу. А может, и две…
 * Поскольку Владислав Исенбаев — выпускник СУНЦ УрГУ, неудивительно, что многие из бывших и действующих олимпиадников УрГУ знакомы с ним уже много лет. Некоторые из них с гордостью заявляют, что играли с Владиславом в одной команде. Или играли в команде с бывшими однокомандниками Владислава…
 * Определим число Исенбаева следующим образом. У самого Владислава это число равняется нулю. У тех, кто играл с ним в одной команде, оно равняется единице. У тех, кто играл вместе с однокомандниками Владислава, но не играл с ним самим, это число равняется двум, и так далее. Помогите автоматизировать процесс вычисления чисел Исенбаева, чтобы каждый олимпиадник в УрГУ мог знать, насколько близок он к чемпиону ACM ICPC.
 * Исходные данные
 * В первой строке записано целое число n — количество команд (1 ≤ n ≤ 100). В каждой из следующих n строк записаны составы этих команд в виде фамилий трёх участников. Фамилия каждого участника — непустая строка, состоящая из английских букв, длиной не более 20 символов. Первая буква фамилии — заглавная, все остальные — строчные. Фамилия Владислава — «Isenbaev».
 * Результат
 * Для каждого участника, представленного во входных данных, выведите в отдельной строке через пробел его фамилию и число Исенбаева. Если это число не определено, выведите вместо него «undefined». Участники должны быть упорядочены по фамилии в лексикографическом порядке.
 * Пример
 * исходные данные	результат
 *
 * 7
 * Isenbaev Oparin Toropov
 * Ayzenshteyn Oparin Samsonov
 * Ayzenshteyn Chevdar Samsonov
 * Fominykh Isenbaev Oparin
 * Dublennykh Fominykh Ivankov
 * Burmistrov Dublennykh Kurpilyanskiy
 * Cormen Leiserson Rivest
 *
 *
 *
 * Ayzenshteyn 2
 * Burmistrov 3
 * Chevdar 3
 * Cormen undefined
 * Dublennykh 2
 * Fominykh 1
 * Isenbaev 0
 * Ivankov 2
 * Kurpilyanskiy 3
 * Leiserson undefined
 * Oparin 1
 * Rivest undefined
 * Samsonov 2
 * Toropov 1
 */