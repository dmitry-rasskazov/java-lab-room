package com.company.laba12;

import java.io.*;

public class example_25_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out=null;
        try {
// Создание файловых символьных потоков для чтения и записи
            br = new BufferedReader( new FileReader("D:\\tmp\\input13.txt" ), 1024);
            out = new BufferedWriter( new FileWriter( "D:\\tmp\\output13.txt" ));
            int lineCount = 0; // счетчик строк
            String s;
// Переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                out.write(s);
                out.newLine(); // переход на новую строку
                // размер буфера
            }
        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        }
        finally{
            br.close();
            out.flush();
            out.close();
        }
    }
}
