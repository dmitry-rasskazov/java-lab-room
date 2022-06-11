package com.company.laba12;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class example_25_10 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        PrintWriter out = null;
        String punctuation = "!?.,;";

        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(
                                    "D:\\tmp\\input13-10.txt"), StandardCharsets.UTF_8));
            out = new PrintWriter("D:\\tmp\\out13-10.txt", String.valueOf(StandardCharsets.UTF_8));

            int lineCount = 0, wordsCount;
            String s;

            while((s = br.readLine()) != null){
                String [] words = s.split(" ");
                wordsCount = 0;
                lineCount++;

                for (int i = 1; i < words.length; i++){

                    if (Character.toUpperCase(words[i].charAt(0)) == (words[0].charAt(0))){
                        if (punctuation.contains(Character.toString(words[i].charAt(words[i].length() - 1)))){
                            words[i] = words[i].substring(0, words[i].length() - 1);
                        }
                        out.println("Строка #" + lineCount + ": Слово '" + words[i] + "'");
                        wordsCount++;
                    }
                }
                out.println("В строке #" + lineCount + " было найдено " + wordsCount + " слов\n");
            }
        }catch (IOException e){
            System.out.println("Ошибка!" + e.getMessage());
        }finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
