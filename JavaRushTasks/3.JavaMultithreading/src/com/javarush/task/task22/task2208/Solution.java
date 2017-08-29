package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        String[] array = {"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null};

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i += 2) {
            map.put(array[i], array[i + 1]);
        }
        String queried = getQuery(map);
        System.out.println(queried);
        String result = "name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'";
        System.out.println(result);
        System.out.println(queried.equals(result));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                builder.append(pair.getKey() + " = \'" + pair.getValue() + "\' and ");
            }
        }
        String result = builder.toString();
        if (result.length() == 0)
            result = "";
        else
            result = result.substring(0, result.length() - 5);

        return result;
    }
}
