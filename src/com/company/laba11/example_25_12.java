package com.company.laba11;

import java.io.*;

public class example_25_12 {
    private static final char[] alphabet = new char[] {
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Ч', 'Ц', 'Ч', 'Ш', 'Щ'
    };

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("D:\\tmp\\input12.txt");
        File output = new File("D:\\tmp\\output12.txt");

        try(
                BufferedReader rf1 = new BufferedReader(new InputStreamReader(new FileInputStream(input), "cp1251"), 1024);
                BufferedWriter wf2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "cp1251"));
        ) {
            String buff;
            int line = 0;
            while((buff = rf1.readLine()) != null) {
                line++;
                try{


                    for(String word: buff.split(" ")) {
                        char sym = word.length() > 0 ? word.charAt(0) : ' ';
                        if (contains(sym)) {
                            String str = String.format("%d: %s", line, word);
                            wf2.write(str, 0,str.length());
                            wf2.newLine();
                        }
                    }
                }catch (IOException e) {
                    break;
                }
            }

            wf2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean contains(char symbol) {
        for(char item: example_25_12.alphabet) {
            if(item == symbol) {
                return true;
            }
        }

        return false;
    }
}
