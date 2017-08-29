package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());

        System.out.print("количество дней в году: " + check(year));
    }

    public static int check(int year) {
        int days = 366;
        if ((year % 100 == 0 && year % 400 != 0) || year % 4 != 0) days = 365;

        return days;
    }
}