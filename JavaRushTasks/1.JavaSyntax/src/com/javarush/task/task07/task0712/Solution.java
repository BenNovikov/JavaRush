package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int minLen = 999, maxLen = 0, minIndex = 0, maxIndex = 0;
        String current;
        for (int i = 0; i < 10; i++) {
            current = reader.readLine();
            list.add(current);
            if (current.length() > maxLen) { maxLen = current.length(); maxIndex = i; }
            if (current.length() < minLen) { minLen = current.length(); minIndex = i; }
        }

        System.out.println(maxIndex < minIndex ? list.get(maxIndex) : list.get(minIndex));
    }
}
