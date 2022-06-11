package com.company.laba12;

import java.io.*;
import java.util.Scanner;

public class example_25_09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in, "cp1251");
// создается файл на диске
        File f = new File("D:\\tmp\\test2-9.txt");
        f.createNewFile();
// -------------ЗАПИСЬ ОБЪЕКТА В ФАЙЛ-------------
// Создается поток для записи объекта
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
// Вводится информация об объекте (стране)
        Strana strana = new Strana();
        System.out.println("Введите информацию о стране: ");
        System.out.print("Название страны => ");
        strana.name = sc.nextLine();
        System.out.print("Площадь страны => ");
        strana.square = sc.nextDouble();
// Объект записывается в файл
        oos.writeObject(strana);
// Дописывается информация и закрывается файловый поток
        oos.flush();
        oos.close();
// -------------ЧТЕНИЕ ОБЪЕКТА ИЗ ФАЙЛА-------------
// Создается поток для чтения объекта из файла
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fis);
// Объект считывается, и на экран выводится требуемая информация
        strana = (Strana) oin.readObject();
        System.out.println(" Название страны " +
                strana.name);
        System.out.println(" ее площадь = " +
                strana.square);
// Поток закрывается
        oos.close();
    }
}

class Strana implements Serializable {
    String name; // название страны
    double square; // площадь страны
}
