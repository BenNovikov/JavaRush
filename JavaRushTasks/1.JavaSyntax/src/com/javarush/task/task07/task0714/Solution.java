package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String buffer1, buffer2;
        int lastIndex;
        for (int i = 0; i < 5; i++) { list.add(reader.readLine()); }
        list.remove(2);
        for (int i = 0; i < list.size()/2; i++) {
            lastIndex = list.size() - i - 1;
            buffer1 = list.get(i);
            buffer2 = list.get(lastIndex);
            list.remove(i);
            list.add(i, buffer2);
            list.remove(lastIndex);
            list.add(lastIndex, buffer1);
        }

        for (String each: list) System.out.println(each);
    }
}


