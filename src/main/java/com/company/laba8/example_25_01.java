package com.company.laba8;

import java.util.Scanner;

public class example_25_01 {
    private static int step=0;

    public static void m(int x) {
        System.out.println("x="+x);
        if ( (2*x+1) <20) {
            m(2*x+1);
        }
    }

    public static void mr(int x) {
        if ( (2*x+1) <20) {
            m(2*x+1);
        }
        System.out.println("x="+x);
    }

    public static void mWs(int x) {
        space();
        System.out.println(x+"-> ");
        step++;
        if ((2*x+1) <20) {
            mWs(2*x+1);
        }
        step--;
        space();
        System.out.println(x+" <-");
    }

    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }

    public static int fact(int n){
        int result;
        if (n==1)
            return 1;
        else{
            result=fact(n-1)*n;
            return result;
        }
    }

    public static int f(int n){
        System.out.printf("x: %d\n", n);
        if (n==0){
            return 0;
        }else
        if (n==1){
            return 1;
        } else {
            return f(n-2)+f(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println(
                "Выбирите математическую функцию и параметр для неё (пример - 1 3):" +
                "\nОбратный порядок вызовов метода для вычисления m - 1" +
                "\nПрямой порядок вызовов метода для вычисления   m - 2" +
                "\nВывод в обоих направлениях вычисления          m - 3" +
                "\nВычисление факториала                          m - 4" +
                "\nВывод числа из ряда фибоначи                   m - 5"
        );
        int method = Integer.parseInt(console.next()), param = Integer.parseInt(console.next());
        switch (method) {
            case 5: f(param);
                break;
            case 4: System.out.print(fact(param));
                break;
            case 3: mWs(param);
                break;
            case 2: mr(param);
                break;
            case 1:
            default: m(param);
        }
    }
}
