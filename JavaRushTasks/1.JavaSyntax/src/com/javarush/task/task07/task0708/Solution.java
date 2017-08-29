package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int[] len = new int[5];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
            len[i] = list.get(i).length();
            if (len[i] > max) max = len[i];
        }

        for (int i = 0; i < 5; i++) {
            if (len[i] == max) System.out.println(list.get(i));
        }
    }
}
