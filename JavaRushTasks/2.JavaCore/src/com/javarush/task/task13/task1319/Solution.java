package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.

1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа должна читывать строки с консоли, пока пользователь не введет строку "exit".
4. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
5. Метод main должен закрывать объект типа BufferedWriter после использования.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        try {
            String fileName = reader.readLine();
            String lineInput = new String();
            do {
                lineInput = reader.readLine();
                list.add(lineInput);
            } while (!lineInput.equals("exit"));

            BufferedWriter stream = new BufferedWriter(new FileWriter(fileName));
            for (String lineOutput : list) {
                    stream.write(lineOutput);
                    stream.newLine();
            }

            stream.close();
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
