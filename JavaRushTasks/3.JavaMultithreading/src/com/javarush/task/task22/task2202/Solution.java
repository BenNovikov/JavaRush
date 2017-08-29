package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.Arrays;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }
        catch (TooShortStringException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(string.split(" ")));
        if (stringArrayList.size() < 5) throw new TooShortStringException();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 4; ++i) result.append(stringArrayList.get(i) + " ");
        result.append(stringArrayList.get(4));
        return result.toString();
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
            this("An Exception Thrown!");
        }

        public TooShortStringException(String message) {

        }
    }
}
