package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

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
            builder.append(fileReader.readLine() + "\n");
        }
        fileReader.close();

        String direct = builder.toString();
        ArrayList<String> directs = new ArrayList<>(Arrays.asList(direct.split("[ \n\r]")));
        String reversed = builder.reverse().toString();
        ArrayList<String> reverseds = new ArrayList<>(Arrays.asList(reversed.split("[ \n\r]")));

        for (String string : directs) {
            builder = new StringBuilder();
            String reverseString = builder.append(string).reverse().toString();
            if (reverseds.contains(reverseString)) {
                reverseds.remove(reverseString);
                if (reverseds.contains(string)) {
                    reverseds.remove(string);
                    if (!string.equals("") && !reverseString.equals("")) {
                        Pair pair = new Pair(reverseString, string);
                        if (!result.contains(pair)) {
                            result.add(pair);
                        }
                    }
                }
            }
        }

        result.stream().map(x -> x.first + " " + x.second).forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
