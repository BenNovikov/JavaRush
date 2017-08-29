package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        StringBuilder builder = new StringBuilder();
        Character previous = ' ';
        Character current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (previous.equals(' ') && Character.isLetter(current)) {
                current = Character.toUpperCase(current);
            }
            builder.append(current);
            previous = current;
        }

        System.out.println(builder);
    }
}
