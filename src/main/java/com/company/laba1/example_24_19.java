package com.company.laba1;

public class example_24_19 {
    public static double hyp(double a, double b){
        return Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double number, double degree) {
        return Math.exp(degree * Math.log(number));
    }

    public static void main(String[] args) {
        double a = 10.0, b = 4.0;

        System.out.println("katet a=" + a);
        System.out.println("katet b=" + b);
        System.out.println("hypotenuse с=" + hyp(a, b));
    }
}
