package com.company.example;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

public class ArrayExample
{
    private static final String URL_REGEXP_PATTERN = "(https?://[^\s]+|(^|\s)[a-z0-9\\-]+.[a-z0-9\\-]+[^\s]+)";

    public static final String PATTERN = "yyMMddHHmmssSSS";

    public static final TimeZone TIME_ZONE_UTC = TimeZone.getTimeZone("UTC");

    private static final Map<Character, Character> REPLACE_CHARS = Map.ofEntries(
            Map.entry('e', 'е'),
            Map.entry('E', 'Е'),
            Map.entry('T', 'Т'),
            Map.entry('y', 'у'),
            Map.entry('O', 'О'),
            Map.entry('o', 'о'),
            Map.entry('P', 'Р'),
            Map.entry('p', 'р'),
            Map.entry('A', 'А'),
            Map.entry('a', 'а'),
            Map.entry('H', 'Н'),
            Map.entry('K', 'К'),
            Map.entry('X', 'Х'),
            Map.entry('x', 'х'),
            Map.entry('C', 'С'),
            Map.entry('c', 'с'),
            Map.entry('B', 'В'),
            Map.entry('M', 'М')
    );

    private static final Character ZERO_SYMBOL = '\u0000';

    private static final Map<Character, Character> REVERSE_REPLACE_CHARS = new HashMap<>();

    static {
        for (Map.Entry<Character, Character> entry : REPLACE_CHARS.entrySet()) {
            REVERSE_REPLACE_CHARS.put(entry.getValue(), entry.getKey());
        }
    }

    private static final byte MESSAGING_MODE_DEFAULT_SMSC = 0;
    private static final byte MESSAGE_TYPE_SMC_DELIVERY_RECEIPT = 1;
    private static final byte GSM_FEATURES_NO_SPECIFIED = 0;
    public static final byte ESM_CLASS =
            ((GSM_FEATURES_NO_SPECIFIED & 0x03) << 6)
                    | ((MESSAGE_TYPE_SMC_DELIVERY_RECEIPT & 0x0F) << 2)
                    | (MESSAGING_MODE_DEFAULT_SMSC & 0x03)
            ;

    public static void main(String[] args) throws ParseException
    {
        System.out.println(Integer.valueOf(0).hashCode());
        System.out.println(Integer.valueOf(1).hashCode());
        System.out.println(Integer.valueOf(0xfff).hashCode());

        Stream.generate(() -> null).forEach(System.out::println);
    }

    interface A
    {
        void method();
    }

    interface B
    {
        void method();
    }

    static class C implements A, B
    {
        @Override
        public void method() {
            System.out.println("Test");
        }
    }

    public class MathUtils
    {
        public static int ABSOLUTE_INTEGER_MAX = 0xFFFFFFFF;

        public static int intLog2(int value)
        {
            return (int) doubleLog2(value);
        }

        public static double doubleLog2(int value)
        {
            return Math.log(value) / Math.log(2);
        }

        public static double bitCount(int value)
        {
            return doubleLog2(value) + 1;
        }

        public static int normalizedHash(int sourceValue, int bitsCount)
        {
            return Objects.hash(sourceValue) & (ABSOLUTE_INTEGER_MAX >>> (Integer.SIZE - bitsCount));
        }
    }

}
