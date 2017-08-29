package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double min = Double.parseDouble(reader.readLine());

        check(min);
    }

    public static void check(double min) {
        String color;

        if (min % 5 < 3) color = "зелёный";
        else if (min % 5 < 4) color = "желтый";
        else color = "красный";

        System.out.println(color);
    }
}