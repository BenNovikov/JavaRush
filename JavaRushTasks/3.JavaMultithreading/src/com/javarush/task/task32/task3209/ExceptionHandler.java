package com.javarush.task.task32.task3209;

import java.io.Console;
import java.io.PrintStream;

/**
 * Created by Ben on 2017-09-29.
 */
public class ExceptionHandler {
    public static void log(Exception e) {
        PrintStream stream = java.lang.System.out;
            stream.println(e.toString());
    }
}
