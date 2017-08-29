package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();

        while (set.size() < 20){
            int randomNum = ThreadLocalRandom.current().nextInt(0, 31);
            set.add(randomNum);
        }
//        System.out.println(set.size() + "...");
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();
            if (i > 10) iter.remove();
        }
        return set;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set = createSet();
//        removeAllNumbersMoreThan10(set);
//        for (Integer el : set ) { System.out.print(el + " "); }
    }
}
