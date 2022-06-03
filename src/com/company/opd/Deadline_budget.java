package com.company.opd;

import java.util.Scanner;

public class Deadline_budget {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int planBudget, curBudget, percent, realBudget;
        float planMonth, curMonth, realMonth;

        System.out.println("Введите плановый бюджет вашего проекта: ");
        planBudget = scan.nextInt();
        if (planBudget <= 0){
            System.out.println("Значения 0 и ниже недопустимы");
            main(args);
        }

        System.out.println("Введите плановый срок выполнения проекта в месяцах: ");
        planMonth = scan.nextFloat();
        if (planMonth <= 0){
            System.out.println("Значения 0 и ниже недопустимы");
            main(args);
        }

        System.out.println("Введите текущий израсходованный бюджет: ");
        curBudget = scan.nextInt();
        if (curBudget <= 0){
            System.out.println("Значения 0 и ниже недопустимы");
            main(args);
        }

        System.out.print("Сколько месяцев прошло с момента начала проекта: ");
        curMonth = scan.nextFloat();
        if (curMonth > planMonth || curMonth <= 0){
            System.out.println("Значения 0 и ниже недопустимы");
            main(args);
        }

        System.out.println("Сколько процентов проекта завершено (введите значение от 0 до 100): ");
        percent = scan.nextInt();
        if (percent < 0 || percent > 100){
            System.out.println("Значения должно быть из ограничено только в пределах [0; 100]");
            main(args);
        }

        realMonth = (100 * curMonth) / percent;

        if (realMonth <= planMonth){
            System.out.println("Задержки по времени нет");
        }
        else {
            System.out.printf("Задержка по времени составит %.1f мес.", (realMonth - planMonth));
        }
        System.out.println();

        realBudget = (100 * curBudget) / percent;

        if (realBudget <= planBudget) System.out.println("Перерасхода нет");
        else System.out.println("Перерасход бюджета составит " + (realBudget - planBudget) + " у. е.");

    }


}

