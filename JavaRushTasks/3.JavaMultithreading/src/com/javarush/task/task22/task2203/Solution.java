package com.javarush.task.task22.task2203;

import java.util.ArrayList;
import java.util.Arrays;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(string.split("\t")));
        if (stringArrayList.size() < 3) throw new TooShortStringException();
        StringBuilder result = new StringBuilder();
        result.append(stringArrayList.get(1));
//        result.append(stringArrayList.get(4));
        return result.toString();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
