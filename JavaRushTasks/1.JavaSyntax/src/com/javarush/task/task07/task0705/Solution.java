package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] s1 = new int[10];
        int[] s2 = new int[10];
        for (int i = 0; i < array.length; i++) array[i] = Integer.parseInt(reader.readLine());
        for (int i = 0; i < s1.length; i++) {
            s1[i] = array[i];
            s2[i] = array[i + s1.length];
            System.out.println(s2[i]);
        }
    }
}
