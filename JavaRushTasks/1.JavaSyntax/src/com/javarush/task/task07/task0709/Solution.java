package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int[] len = new int[5];
        int min = 99999;

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
            len[i] = list.get(i).length();
            if (len[i] < min) min = len[i];
        }

        for (int i = 0; i < 5; i++) {
            if (len[i] == min) System.out.println(list.get(i));
        }
    }
}
