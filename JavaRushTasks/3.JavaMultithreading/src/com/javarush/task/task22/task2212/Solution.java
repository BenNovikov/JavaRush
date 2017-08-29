package com.javarush.task.task22.task2212;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;
        int count = telNumber.replaceAll("\\D", "").length();
        if (telNumber.charAt(0) == '+' && count != 12 || telNumber.charAt(0) == '(' && count != 10) return false;
        return telNumber.matches("\\+{0,1}\\d{0,2}\\(*\\d{3}\\)*\\d{3}\\-*\\d{2}\\-*\\d{2}") ;
//        if (telNumber.substring(0, 1) == "+" && countDigits(telNumber) != 12) return false;
//        if (telNumber.substring(0, 1) == "(" && countDigits(telNumber) != 10) return false;
//        if (isDigit(telNumber.substring(0, 1)) && countDigits(telNumber) != 10) return false;
//        if (telNumber.contains("-")) {
//            int counter = telNumber.length() - telNumber.replaceAll("-", "").length();
//            if (counter > 2 || telNumber.contains("--")) return false;
//        }
//        if (telNumber.contains(")")) {
//            String[] part = telNumber.split("\\)");
//            if (part[0].contains("-") || !part[0].contains("(")) return false;
//            String[] subPart = part[0].split("\\(");
//            if (countDigits(subPart[1]) != 3) return false;
//        }
//        for (int i = 0; i < telNumber.length(); ++i) {
//            String str = telNumber.substring(i, i + 1);
//            if (!(str.matches("[0-9]") ||
//                    str.matches("[\\+]") ||
//                    str.matches("[\\(]") ||
//                    str.matches("[\\)]") ||
//                    str.matches("[\\-]"))) return false;
//        }
//        if (!isDigit(telNumber.substring(telNumber.length() - 1, telNumber.length()))) return false;

//        return true;
    }

//    public static int countDigits(String string) {
//        return string.replaceAll("\\D", "").toCharArray().length;
//    }
//
//    public static boolean isDigit(String string) {
//        return string.substring(0, 1).matches("\\d");
//    }

    public static void main(String[] args) {
        ArrayList<String> trueNumbers = new ArrayList<>(Arrays.asList(new String[]
                {"+38050123-45-67", "050123-4567", "+380501234567", "+38(050)1234567"}));
        ArrayList<String> falseNumbers = new ArrayList<>(Arrays.asList(new String[]
                {"+38)050(1234567","+38(050)1-23-45-6-7","050ххх4567","050123456","(0)501234567"}));

        for (String number : trueNumbers) {
            System.out.println(number + ":" + checkTelNumber(number) + " ");
        }
        for (String number : falseNumbers) {
            System.out.println(number + ":" + checkTelNumber(number) + " ");
        }
    }
}
