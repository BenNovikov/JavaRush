package com.javarush.task.task25.task2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() {
        String string = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                string = reader.readLine();
            }
            catch (IOException e) {
            }
        return string;
    }

    public static int readInt() {
        int result = 0;
        try {
            result = Integer.parseInt(readString());
        }
        catch (IllegalArgumentException e) {
        }
        return result;
    }
}
