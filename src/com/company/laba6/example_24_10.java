package com.company.laba6;

public class example_24_10 {
    public static int max(int[] series) {
        int result = series[0];

        for(int current: series) {
            result = Math.max(current, result);
        }

        return result;
    }

    public static int min(int[] series) {
        int result = series[0];

        for(int current: series) {
            result = Math.min(current, result);
        }

        return result;
    }

    public static int[] getEndNumbers(int ... series) {
        return new int[]{min(series), max(series)};
    }

    public static void main(String[] args) {
        int[] numbers = {1,11,12,20,14,1,8,52,32,45,74,23,2,5,4,8,6,5,8,52};

        System.out.println("Имеется массив чисел: ");
        for(int number: numbers) {
            System.out.print("\t" + number);
        }

        int[] ends = getEndNumbers(numbers);

        System.out.printf("\nУрайними значениями массива, по величине, являются [%d, %d]", ends[0], ends[1]);
        // тест наследования
        A test1 = new B(12);
        A test2 = new C(12);

        System.out.printf("\n\n\t%d\t%d", test1.getConcreteLen(), test2.getConcreteLen());
    }
}

abstract class A {
    private int len;

    A(int len) {
        this.len = len;
    }

    protected abstract int coefficient();

    public int getConcreteLen() {
        return this.coefficient() * this.len;
    }
}

class B extends A {
    B(int len) {
        super(len);
    }

    protected int coefficient() {
        return 2;
    }
}

class C extends A {
    C(int len) {
        super(len);
    }

    protected int coefficient() {
        return 3;
    }
}
