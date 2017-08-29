package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i += 2) {
            map.put("Name" + i, 1000);
            map.put("Name" + i + 1, 450);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = createMap();
//        for (Map.Entry<String, Integer> pair: map.entrySet()){
//            System.out.println(pair.getKey()+ " " + pair.getValue());
//        }
//        System.out.println();
//        removeItemFromMap(map);
//        for (Map.Entry<String, Integer> pair: map.entrySet()){
//            System.out.println(pair.getKey()+ " " + pair.getValue());
//        }
    }
}