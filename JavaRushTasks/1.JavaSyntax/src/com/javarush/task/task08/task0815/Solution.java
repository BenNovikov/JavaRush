package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» — «Имя».
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
5. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
6. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; i++) { map.put("First" + i, "Name#" + i);}
        for (int i = 0; i < 3; i++) { map.put("Second" + i, "Name#" + i);}
        for (int i = 0; i < 3; i++) { map.put("Third" + i, "Name#" + i);}
//        for (HashMap.Entry<String, String> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
//        for (HashMap.Entry<String, String> pair : map.entrySet()) {
//        if (name.equals(pair.getValue())) count++;
        for (String val : map.values()) {
            if (name.equals(val)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
//        for (HashMap.Entry<String, String> pair : map.entrySet()) {
//            if (lastName.equals(pair.getKey())) count++;
        for (String key : map.keySet()) {
            if (lastName.equals(key)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        System.out.println(getCountTheSameFirstName(map, "Name#1"));
//        System.out.println(getCountTheSameLastName(map, "First"));
    }
}
