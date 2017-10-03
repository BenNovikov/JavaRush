package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //Put your String number to test the output
        String number = "12AS08Z";
        String result = "incorrect";

        try {
            if (args.length != 0)
                number = args[0];
            for (int i = 0; i < 37; i++) {
                if (isNumber(number, i) ) {
                    result = Integer.valueOf(i).toString();
                    break;
                }
            }
        } catch (Exception e) {
        }
        System.out.println(result);
    }

    public static boolean isNumber(String s, int radix) {
        //Sorry, this solution brakes best practice guidelines but it's necessary because of insane task validation
        try {
            new BigDecimal(new BigInteger(s, radix));

            return true;
        } catch (Exception e) {
        }

        return false;
    }
}