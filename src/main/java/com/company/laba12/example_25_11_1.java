package com.company.laba12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class example_25_11_1 {
    public static void main(String[] args) {
        try {
            File f1 = new File("D:\\tmp\\test-11.txt");
            if (!f1.exists()) f1.createNewFile();
            File f2 = new File("D:\\tmp\\test1-11.txt");
            if (!f2.exists()) f2.createNewFile();

            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            RandomAccessFile wf = new RandomAccessFile(f2, "rw");

            Scanner scan = new Scanner(System.in);

            System.out.print("Введите количество фильмов для записи в файл => ");
            int kol = scan.nextInt();
            System.out.println();
            scan.nextLine();

            String filmName, filmCountry, filmGenre;
            int filmYear, rentalCost;

            for (int i = 0; i < kol; i++){
                System.out.print("Введите название " + (i+1) + " фильма => ");
                filmName = scan.nextLine();
                System.out.println();
                rf.seek(rf.length());
                rf.writeUTF(filmName);
                for (int j = 0; j < 30 - filmName.length(); j++) rf.writeByte(1);

                System.out.print("Введите страну выпуска фильма => ");
                filmCountry = scan.nextLine();
                System.out.println();
                rf.writeUTF(filmCountry);
                for (int j = 0; j < 30 - filmCountry.length(); j++) rf.writeByte(1);

                System.out.print("Введите жанр фильма => ");
                filmGenre = scan.nextLine();
                System.out.println();
                rf.writeUTF(filmGenre);
                for (int j = 0; j < 30 - filmGenre.length(); j++) rf.writeByte(1);

                System.out.print("Введите год выпуска фильма => ");
                filmYear = scan.nextInt();
                System.out.println();
                rf.writeInt(filmYear);

                System.out.print("Введите стоимость проката => ");
                rentalCost = scan.nextInt();
                System.out.println();
                scan.nextLine();
                rf.writeInt(rentalCost);
            }
            rf.close();

            rf = new RandomAccessFile(f1, "r");

            rf.seek(0);

            for (int i = 0; i < kol; i++){
                filmName = rf.readUTF();
                for (int j = 0; j < 30 - filmName.length(); j++) rf.readByte();

                filmCountry = rf.readUTF();
                for (int j = 0; j < 30 - filmCountry.length(); j++) rf.readByte();

                filmGenre = rf.readUTF();
                for (int j = 0; j < 30 - filmGenre.length(); j++) rf.readByte();

                filmYear = rf.readInt();
                rentalCost = rf.readInt();

                if (filmCountry.equals("Россия") || filmCountry.equals("РФ")
                        || filmCountry.equals("россия")){

                    System.out.println("===== Следующий фильм записан в файл =====");
                    wf.seek(wf.length());
                    System.out.println("Название фильма: " + filmName);
                    wf.writeUTF(filmName);
                    for (int k = 0; k < 30 - filmName.length(); k++) wf.writeByte(1);

                    System.out.println("Наименование страны: " + filmCountry);
                    wf.writeUTF(filmCountry);
                    for (int k = 0; k < 30 - filmCountry.length(); k++) wf.writeByte(1);

                    System.out.println("Жанр фильма: " + filmGenre);
                    wf.writeUTF(filmGenre);
                    for (int k = 0; k < 30 - filmGenre.length(); k++) wf.writeByte(1);

                    System.out.println("Год выпуска: " + filmYear);
                    wf.writeInt(filmYear);

                    System.out.println("Стоимость проката: " + rentalCost);
                    wf.writeInt(rentalCost);
                    System.out.println();
                }

            }
            rf.close();
            wf.close();

        }catch (IOException e){
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
