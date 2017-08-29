package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
Программа должна создавать массив на 10 строк.
2. Программа должна создавать массив на 10 целых чисел.
3. Программа должна считывать строки для массива с клавиатуры.
4. Программа должна в массив чисел записать длины строк из массива строк, а затем их вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[10];
        int[] lens = new int[10];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = reader.readLine();
            lens[i] = lines[i].length();
        }

        for (int i = 0; i < lines.length; i++) System.out.println(lens[i]);
    }
}
