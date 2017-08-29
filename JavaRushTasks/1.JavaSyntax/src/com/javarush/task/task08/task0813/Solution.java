package com.javarush.task.task08.task0813;

import java.util.HashSet;

/* 
20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только два метода.
4. Метод createSet() должен создавать и возвращать множество HashSet.
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<>();
        String[] words = new String[20];
        for (int i = 0; i < 20; i++) { words[i] = "Л" + i; }
        for (String each : words) { set.add(each); }
        return set;
    }

    public static void main(String[] args) {

    }
}
