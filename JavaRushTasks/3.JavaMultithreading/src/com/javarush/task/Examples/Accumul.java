package com.javarush.task.Examples;

import java.lang.StringBuilder;
import java.util.Collections;

//https://www.codewars.com/kata/mumbling/train/java

public class Accumul {
    public static void main(String[] param) {
        testing(Accumul.accum("ZpglnRxqenU"), "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
        testing(Accumul.accum("NyffsGeyylB"), "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb");
        testing(Accumul.accum("MjtkuBovqrU"), "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu");
        testing(Accumul.accum("EvidjUnokmM"), "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm");
        testing(Accumul.accum("HbideVbxncC"), "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc");
    }

    public static void testing(String received, String expected) {
        System.out.println(received);
        System.out.println(expected);
        System.out.print(received.equals(expected) ?
                "Test passed " + String.join("", Collections.nCopies(20, "+")) :
                "Test failed " + String.join("", Collections.nCopies(20, "x"))
        );
        System.out.println();
    }

    public static String accum(String s) {
        StringBuilder b = new StringBuilder();
        for(int counter = 0; counter < s.length(); counter++) {
            char c = s.toLowerCase().charAt(counter);
            for(int i = 1; i <= counter + 1; i++) {
                if(i == 1)
                    b.append(Character.toString(c).toUpperCase());
                else
                    b.append(c);
            }
            b.append("-");
        }
        b.delete(b.length() - 1, b.length());
        return b.toString();
    }
}
