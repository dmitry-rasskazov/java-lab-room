package com.company.laba12;

import java.io.*;
import java.util.Scanner;

class FilmInfo implements Serializable {

    String filmName, filmCountry, filmGenre;
    int filmYear, rentalCost;
}

public class example_25_11_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        File f1 = new File("D:\\tmp\\test-test.txt");
        File f2 = new File("D:\\tmp\\test2-11.txt");
        if (!f1.exists()) f1.createNewFile();
        if (!f2.exists()) f2.createNewFile();

        FileOutputStream fos = new FileOutputStream(f1);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FilmInfo filmInfo = new FilmInfo();
        System.out.println("Сколько фильмов вы хотите записать в файл? => ");
        int kol = scan.nextInt();
        scan.nextLine();

        System.out.println("Введите информцию о фильмах");
        for (int i = 0; i < kol; i++){
            System.out.println("Введите название " + (i+1) + " фильма => ");
            filmInfo.filmName = scan.nextLine();

            System.out.println("Введите страну выпуска фильма => ");
            filmInfo.filmCountry = scan.nextLine();

            System.out.println("Введите жанр фильма =>");
            filmInfo.filmGenre = scan.nextLine();

            System.out.println("Введите год выпуска фильма => ");
            filmInfo.filmYear = scan.nextInt();

            System.out.println("Введите стоимость проката => ");
            filmInfo.rentalCost = scan.nextInt();

            oos.writeObject(filmInfo);

            scan.nextLine();
        }
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(f1);
        ObjectInputStream ois = new ObjectInputStream(fis);
        fos = new FileOutputStream(f2);
        oos = new ObjectOutputStream(fos);

        for (int i = 0; i < kol; i++){

            filmInfo = (FilmInfo) ois.readObject();

            if      (filmInfo.filmCountry.equals("Россия") ||
                    filmInfo.filmCountry.equals("РФ")      ||
                    filmInfo.filmCountry.equals("россия")  ){

                System.out.println("===== Следующий фильм записан в файл =====");
                System.out.println("Название: " + filmInfo.filmName);
                System.out.println("Страна выпуска: " + filmInfo.filmCountry);
                System.out.println("Жанр фильма: " + filmInfo.filmGenre);
                System.out.println("Год выпуска: " + filmInfo.filmYear);
                System.out.println("Стоимость проката: " + filmInfo.rentalCost);
                System.out.println();
                oos.writeObject(filmInfo);
            }
        }
        oos.flush();
        oos.close();
        ois.close();
    }
}
