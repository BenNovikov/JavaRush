package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int sum = Integer.parseInt(reader.readLine());
        int years = Integer.parseInt(reader.readLine());

        System.out.print(name + " получает " + sum + " через " + years + " лет.");
    }
}
