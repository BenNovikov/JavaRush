package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] origin = {1, 2, 4, 55, 4, 35, 67, 88, 12, 33, 7, 3, 24, 15};
//        Integer[] sorted = sort(origin);
//        for (Integer i : sorted) System.out.print(i + " ");
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int len = array.length;
        int median = len % 2 == 0 ? (array[len/2] + array[len/2 - 1])/2 : array[len/2];
        //implement logic here
//        final Comparator<Integer> medianDistance = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Math.abs(median - o1) - Math.abs(median - o2);
//            }
//        };
        final Comparator<Integer> medianDistance = (o1, o2) -> Math.abs(median - o1) - Math.abs(median - o2);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list, medianDistance);
        return list.toArray(new Integer[len]);
    }
}
