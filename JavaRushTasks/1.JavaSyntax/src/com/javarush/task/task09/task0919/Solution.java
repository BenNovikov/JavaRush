package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) throws ArithmeticException {
        try {
            divisionByZero();
        }
        catch (ArithmeticException exception) {
            exception.printStackTrace();
        }
    }

    public static void divisionByZero() throws ArithmeticException {
        System.out.println(100 / 0);
    }
}
