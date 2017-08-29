package com.javarush.task.task03.task0313;

/*
Мама мыла раму
*/
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] word = {"Мама", "Мыла", "Раму"};
//        combinations(word, 3, 0, new String[3]);

        int len = word.length;

        for (int i = 0; i < len; i++)
        {
            System.out.print(word[i]);
            for (int j = 0; j < len; j++) {
                System.out.print(i != j ? word[j] : "");
            }
            System.out.println();

            System.out.print(word[i]);
            for (int k = len - 1; k >= 0; k--) {
                System.out.print(i != k ? word[k] : "");
            }
            System.out.println();
        }
    }

//    public static void combinations(String[] array, int len, int start, String[] result) {
//        if (len == 0){
//            System.out.println(Arrays.toString(result));
//            return;
//        }
//        for(int i = start; i <= array.length - len; i++) {
//            result[result.length - len] = array[i];
//            System.out.print(i);
//            combinations(array, len - 1, i + 1, result);
//        }
//    }
}
