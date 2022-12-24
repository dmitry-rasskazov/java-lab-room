package com.company.timus;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Hieroglyph
{
    private static InputStream console = new BufferedInputStream(System.in, 2048);

    private static OutputStream printer = new BufferedOutputStream(System.out, 128);

    private static final short LENGTH = 'z' - 'a' + 1;

    public static void main(String[] args) throws IOException {

//        boolean[][] result = new boolean[LENGTH][LENGTH];
//        for (boolean[] item: result) {
//            Arrays.fill(item, false);
//        }

        Set<Byte>[] result = new Set[LENGTH];
        int n = nextInt();
        byte buf;
        for(int i = 0; i < n; i++)
        {
            buf = (byte) (nextSymbolByte() - 'a');
            if(null == result[buf]) {
                result[buf] = new HashSet<>();
            }
            result[buf].add((byte)(nextSymbolByte() & 0xff));
        }
//        short index;
//
//        for (int i = 0; i < n; i++) {
//            index = (short) (console.read() - 'a');
//            result[index][console.read() - 'a'] = true;
//            console.skip(2);
//        }
//
//        short last = (short) console.read(), lastIndex = (short) (last - 'a');
//        for (short i = 0; i < result[lastIndex].length; i++) {
//            if (result[lastIndex][i]) {
//                printer.write(last);
//                printer.write(i + 'a');
//                printer.write('\n');
//            }
//        }
        buf = nextSymbolByte();
        for (Byte item: null == result[buf - 'a'] ? new LinkedList<Byte>() : result[buf - 'a']) {
            printer.write(buf);
            printer.write(item);
            printer.write('\n');
        }
        printer.write('\n');
        printer.flush();

        console.close();
        printer.close();
    }

    private static int nextInt() throws IOException {
        int result = 0;
        short buf;
        boolean captured = false;
        while ((buf = (short) console.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = ((result * 10) + (buf - '0'));
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }

    private static byte nextSymbolByte() throws IOException {
        byte buf;
        if((buf = (byte) console.read()) != -1) {
            if(buf >= 'a' && buf <= 'z') {
                return buf;
            } else {
                return nextSymbolByte();
            }
        } else {
            throw new IOException();
        }
    }
}
