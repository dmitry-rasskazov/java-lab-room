package com.company.timus;

import java.util.Scanner;

public class LocaleProblem {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int amount = console.nextInt();
        String result;

        if (amount <= 4)
            result = "few";
        else if (amount >= 5 && amount <= 9)
            result = "several";
        else if (amount >= 10 && amount <= 19)
            result = "pack";
        else if (amount >= 20 && amount <= 49)
            result = "lots";
        else if (amount >= 50 && amount <= 99)
            result = "horde";
        else if (amount >= 100 && amount <= 249)
            result = "throng";
        else if (amount >= 250 && amount <= 499)
            result = "swarm";
        else if (amount >= 500 && amount <= 999)
            result = "zounds";
        else if (amount >= 1000)
            result = "legion";
        else
            throw new RuntimeException("Bad input");

        System.out.println(result);
    }
}

/**
 * №1785
 *
 * Компания Lavin Interactive, разработчик пошаговой стратегии Losers-V, постоянно расширяет рынки сбыта и создаёт локализации своей игры даже на самые малоизвестные языки. В том числе, их заинтересовал язык племени австралийских аборигенов аниндилъяква.
 * Но в языке аниндилъяква нет числительных. Как же, например, перевести на него фразу «у вас семь чёрных драконов, а у вашего врага — сорок»? Локализаторы решили перевести её так: «у вас немного чёрных драконов, а у вашего врага — толпа». Они составили таблицу, в которой указали правила замены чисел, обозначающих количество монстров, на существительные и местоимения:
 * Количество 	Обозначение на русском языке 	Обозначение на языке аниндилъяква
 * от 1 до 4 	несколько 	few
 * от 5 до 9 	немного 	several
 * от 10 до 19 	отряд 	pack
 * от 20 до 49 	толпа 	lots
 * от 50 до 99 	орда 	horde
 * от 100 до 249 	множество 	throng
 * от 250 до 499 	сонмище 	swarm
 * от 500 до 999 	полчище 	zounds
 * от 1000 	легион 	legion
 * Помогите локализаторам автоматизировать процесс — напишите программу, которая по количеству монстров выдаст соответствующее этому количеству слово.
 */

