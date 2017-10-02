package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append(a);
        int t = a;
        switch (Integer.valueOf(a).compareTo(b)) {
            case 1:
                while (t > b) {
                    result.append(" ").append(--t);
                }
                break;
            case -1:
                while (t < b) {
                    result.append(" ").append(++t);
                }
                break;
            case 0:
                return Integer.toString(a);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}