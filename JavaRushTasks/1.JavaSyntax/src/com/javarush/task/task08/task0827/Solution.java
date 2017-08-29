package com.javarush.task.task08.task0827;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date ddate = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("D");
        int day = Integer.parseInt(format.format(ddate)) + 1;
        return day % 2 == 0;
    }
}
