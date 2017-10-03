package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int radix = 10;
        if (s.startsWith("0")) {
            switch (s.charAt(1)) {
                case 'x' :
                    radix = 16;
                    s = s.substring(2);
                    break;
                case 'b' :
                    radix = 2;
                    s = s.substring(2);
                    break;
                default:
                    radix = 8;
            }
        }
        Integer result = Integer.parseInt(s, radix);

        return result.toString();
    }
}
