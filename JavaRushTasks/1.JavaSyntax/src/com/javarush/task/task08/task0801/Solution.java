package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] array = {"арбуз", "банан", "вишня", "груша", "дыня", "ежевика",
                "жень-шень", "земляника", "ирис", "картофель"};
        HashSet<String> hashSet = new HashSet(Arrays.asList(array));
//        HashSet<String> hashSet = new HashSet<>();
//        for (String each: array) { hashSet.add(each); }

        for (String each: hashSet) { System.out.println(each); }
    }
}
