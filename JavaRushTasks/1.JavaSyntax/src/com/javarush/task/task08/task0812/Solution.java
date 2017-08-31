package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3
Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа ArrayList с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int maxStreak = 1, currentStreak = 1;
        try {
            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }
        } catch (Exception e) {

        }
        int previous = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current == previous) {
                currentStreak++;
                if (currentStreak > maxStreak) maxStreak = currentStreak;
            } else {
                previous = current;
                currentStreak = 1;
            }
//            System.out.print(maxStreak + ".");
        }
        System.out.println(maxStreak);
    }
}