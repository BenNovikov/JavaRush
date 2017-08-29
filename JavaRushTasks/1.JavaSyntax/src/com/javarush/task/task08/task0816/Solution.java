package com.javarush.task.task08.task0816;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» — «дата рождения».
Удалить из словаря всех людей, родившихся летом.
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
5. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/


public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone0", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JULY 1 1980"));
        map.put("Stallone2", new Date("AUGUST 1 1980"));
        map.put("Stallone3", new Date("MAY 1 1980"));
        map.put("Stallone4", new Date("MAY 1 1980"));
        map.put("Stallone5", new Date("JUNE 1 1980"));
        map.put("Stallone6", new Date("MAY 1 1980"));
        map.put("Stallone7", new Date("MAY 1 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("MAY 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
//        System.out.println(map.size());
        Iterator<String> i = map.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            Date date = (Date)map.get(key);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
//            System.out.println(date.toString());
            int month = cal.get(Calendar.MONTH);
            if (month < 8 && month > 4) {
                i.remove();
            }
        }
//        System.out.println(map.size());
    }

    public static void main(String[] args) {
//        HashMap<String, Date> map = createMap();
//        removeAllSummerPeople(map);
    }
}
