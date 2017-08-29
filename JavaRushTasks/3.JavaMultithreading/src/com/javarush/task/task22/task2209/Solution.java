package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (fileName.length() == 0) {
            fileName = "C:\\WorkShop\\Java\\JavaRush\\temp.txt";
        }
        reader.close();

        StringBuilder builder = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            builder.append(fileReader.readLine() + " ");
        }
        fileReader.close();

        String[] words = builder.toString().split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        // for (String word : result.toString().split(" "))
        //     System.out.println(word);
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if (words.length != 0) {
            for (String word : sort(words)) {
                if (word == null)
                    word = "";
                builder.append(word + " ");
            }

            builder.replace(builder.length() - 1, builder.length(), "");
        }
        return builder.length() == 0 ? builder.append("") : builder;
    }

    public static char lastChar(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        return chars[chars.length - 1];
    }
    public static char firstChar(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        return chars[0];
    }

    public static String[] sort(String[] words) {
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(words));
        if (array.size() > 1) {
            String first = array.get(0);
            for (int i = 0; i < array.size(); ++i) {
                if (firstChar(array.get(i)) < firstChar(first))
                    first = array.get(i);
            }
            array.remove(first);
            array.add(0, first);

            for (int i = 0; i < array.size() - 2; ++i) {
                if (lastChar(array.get(i)) != firstChar(array.get(i + 1))) {
                    for (int j = i + 2; j < array.size(); ++j) {
                        if (lastChar(array.get(i)) == firstChar(array.get(j))) {
                            String found = array.get(j);
                            array.remove(found);
                            array.add(i + 1, found);
                            break;
                        }
                    }
                }
            }
        }

        String[] result = new String[array.size()];
        return array.toArray(result);
    }
}
