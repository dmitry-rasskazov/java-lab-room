package com.company.example;

import java.io.*;
public class WordCombiner {

    public static void main(String[] args) {
        File input = new File("D:\\tmp\\input.csv");

        try(
                BufferedReader br = new BufferedReader(new FileReader(input), 8192);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 8192);
                ) {
            int fileSize = (int) input.length();
            String[][] matrix = new String[fileSize][3];
            for(int i = 0; i < fileSize; i++) {
                String row;
                if((row = br.readLine()) != null) {
                    matrix[i] = row.split(";");
                }
            }

            for (int i = 0; i < fileSize; i++) {
                for (int j = 0; j < fileSize; j++) {
                    if(
                            matrix[i] != null
                            && matrix[j] != null
                            && matrix[i][0] != null
                            && matrix[j].length > 1
                            && matrix[j][1] != null
                            && !matrix[i][0].equals(" ") && !matrix[i][0].equals("")
                            && !matrix[j][1].equals(" ") && !matrix[j][1].equals("")
                    ) {
                        bw.write(matrix[j][1] + " " + matrix[i][0]);
                        bw.newLine();
                    }
                }
            }

            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
