package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Программа должна считывать данные с консоли.
2. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
3. Программа должна выводить данные на экран.
4. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        try {
//        String fileName = "D:\\Workshop\\Java\\Javarush\\text.txt";
            String fileName = inputReader.readLine();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (fileReader.ready()) {
                int read = Integer.parseInt(fileReader.readLine());
                if (read % 2 == 0) list.add(read);
            }
            Collections.sort(list, new AscendingComparator());
            for (int element : list) System.out.println(element);

            if (fileReader != null) fileReader.close();
            if (inputReader != null) inputReader.close();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    public static class DescendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class AscendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
