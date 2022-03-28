package com.company.laba9;

import java.util.*;

public class example_25 {
    private static Scanner console;
    private static final int OPTION = 5;
    private static final int BASE_SIZE = 100000;
    private static final int SIZE = BASE_SIZE * OPTION;

    public static void main(String[] args) {
        console = new Scanner(System.in);

        System.out.print(
                "Выбирете вариант коллекции из предложенных:" +
                "\n1 - HashMap" +
                "\n2 - TreeMap" +
                "\n3 - TreeSet" +
                "\n> "
        );

        int structureType = Integer.parseInt(console.nextLine());
        long avgNanoTine;

        System.out.println("Подождите...");
        if(structureType == 3) {
            TreeSet<Integer> exampleTreeSet = new TreeSet<>();
            for (int i = 0; i < SIZE; i++) {
                exampleTreeSet.add(i);
            }

            System.out.println("Выберите действие: ");
            avgNanoTine = exampleTreeSet(select(
                    "\n1 - Вставка в коллекцию" +
                    "\n2 - Удаление из коллекции" +
                    "\n> "
            ), exampleTreeSet);
        } else if(structureType == 2) {
            TreeMap<String, Integer> exampleTreeMap = new TreeMap<>();
            for (int i = 0; i < SIZE; i++) {
                exampleTreeMap.put("" + i, i);
            }

            System.out.println("Выберите действие: ");
            avgNanoTine = exampleMap(select("\n1 - Вставка в карту" +
                    "\n2 - Удаление из карты" +
                    "\n3 - Поиск по ключу" +
                    "\n> "
            ), exampleTreeMap);
        } else {
            HashMap<String, Integer> exampleHashMap = new HashMap<>();
            for (int i = 0; i < SIZE; i++) {
                exampleHashMap.put("" + i, i);
            }

            System.out.println("Выберите действие: ");
            avgNanoTine = exampleMap(select("\n1 - Вставка в карту" +
                    "\n2 - Удаление из карты" +
                    "\n3 - Поиск по ключу" +
                    "\n> "
            ), exampleHashMap);
        }

        System.out.println("Среднее время этой операции составляет: " + avgNanoTine + " нс.");
    }

    private static int select(String selectFrom) {
        System.out.print(selectFrom);
        int option = Integer.parseInt(console.nextLine());
        System.out.println();

        return option;
    }

    private static long exampleMap(int option, Map<String, Integer> instance) {
        long averageNanoTime = 0, current;

        if(option == 3) {
            for (int i = 0; i < 10; i++, averageNanoTime = i == 0 ? current : (averageNanoTime + current) / 2) {
                long before = System.nanoTime();
                instance.get("" + i);
                current = System.nanoTime() - before;
            }
        } else if(option == 2) {
            for (int i = 0; i < 10; i++, averageNanoTime = i == 0 ? current : (averageNanoTime + current) / 2) {
                long before = System.nanoTime();
                instance.remove("" + i);
                current = System.nanoTime() - before;
            }
        } else {
            for (int i = 0; i < 10; i++, averageNanoTime = i == 0 ? current : (averageNanoTime + current) / 2) {
                long before = System.nanoTime();
                instance.put("" + i + SIZE, i);
                current = System.nanoTime() - before;
            }
        }

         return averageNanoTime;
    }

    private static long exampleTreeSet(int option, TreeSet<Integer> instance) {
        long averageNanoTime = 0, current;

        if(option == 2) {
            for (int i = 0; i < 10; i++, averageNanoTime = i == 0 ? current : (averageNanoTime + current) / 2) {
                long before = System.nanoTime();
                instance.remove(i);
                current = System.nanoTime() - before;
            }
        } else {
            for (int i = 0; i < 10; i++, averageNanoTime = i == 0 ? current : (averageNanoTime + current) / 2) {
                long before = System.nanoTime();
                instance.add(i + SIZE);
                current = System.nanoTime() - before;
            }
        }

        return averageNanoTime;
    }
}
