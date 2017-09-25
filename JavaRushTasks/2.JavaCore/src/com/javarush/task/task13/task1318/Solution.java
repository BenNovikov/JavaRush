package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = ""; //D:\Workshop\Java\Javarush\text.txt
        try {
            fileName = reader.readLine();
            FileInputStream stream = new FileInputStream(fileName);
            while (stream.available() > 0) {
                int line = stream.read();
                System.out.print((char) line);
            }
            System.out.println();
            stream.close();
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}