package com.javarush.task.task05.task0507;

import java.io.*;

/*
Среднее арифметическое
Вводить с клавиатуры числа и вычислить среднее арифметическое.
Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
-1 не должно учитываться.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count = 0;
        int val = 0;
        while (true) {
            val = Integer.parseInt(reader.readLine());
            if (val == -1) break;
            sum += val;
            count++;
//            System.out.println(sum + ":" + count);
        }

        System.out.println((double)sum/(double)count);
    }
}

