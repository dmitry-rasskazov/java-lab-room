package com.company;

import java.util.LinkedList;
import java.util.List;

public class Regexp {

    public static void main(String[] args) {
        String body = "Hello World, how are you? welcome Did you know that welcome World word is prohibited?";
        String[] prohibited = {"World", "know", "welcome", "prohibited"};

        List<String> parts = new LinkedList<>();
        parts.add(body);

        String part, firstSubPart, secondSubPart;
        int mediaPosition, positionInPart;
        for(String word: prohibited) {
            word = word.trim();
            mediaPosition = (short) (word.length() / 2);
            for(int i = 0; i < parts.size(); i++) {
                part = parts.get(i);

                while((positionInPart = part.indexOf(word)) != -1) {
                    positionInPart += mediaPosition;
                    firstSubPart = part.substring(0, positionInPart);
                    secondSubPart = part.substring(positionInPart);

                    parts.set(i, firstSubPart);
                    parts.add(++i, secondSubPart);
                    part = secondSubPart;
                }
            }
        }

        parts.forEach(System.out::println);
    }
}