package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> quantity = new ArrayList<>();
        for (int i = 0; i < abcArray.length; i++) {
            quantity.add(0);
        }

        for (String line: list) {
            for (int i = 0; i < line.length(); i++) {
                Character current = line.charAt(i);
                if (current >= alphabet.get(0) && current <= alphabet.get(alphabet.size() - 1)) {
                    try {
                        Integer index = alphabet.indexOf(current);
                        Integer value = quantity.get(index) + 1;
//                System.out.print(current + ":" + index + ":" + value + " ");
                        quantity.set(index, value);
                    }
                    catch (Exception e) {

                    }
                }
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + quantity.get(i));
        }
    }
}
