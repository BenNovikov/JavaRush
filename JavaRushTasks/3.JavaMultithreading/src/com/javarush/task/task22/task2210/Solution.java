package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for(String token: getTokens("level22.lesson13.task01", ".")) {
            System.out.println(token);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokens = new StringTokenizer(query, delimiter);
        String[] array = new String[tokens.countTokens()];
        int i = 0;
        while (tokens.hasMoreTokens()) {
            array[i] = tokens.nextToken();
            ++i;
        }

        return array;
    }
}
