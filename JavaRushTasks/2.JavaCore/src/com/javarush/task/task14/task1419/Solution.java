package com.javarush.task.task14.task1419;

import com.sun.org.apache.xpath.internal.operations.String;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
ArrayStoreException                 Assignment to an array element of an incompatible type.
ClassCastException                  Invalid cast.
IllegalArgumentException            Illegal argument used to invoke a method.
IllegalMonitorStateException        Illegal monitor operation, such as waiting on an unlocked thread.
IllegalStateException               Environment or application is in incorrect state.
IllegalThreadStateException         Requested operation not compatible with the current thread state.
IndexOutOfBoundsException           Some type of index is out-of-bounds.
NegativeArraySizeException
*/

public class Solution {
    static java.lang.String[] ex = {"sun"};
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try { float i = 1 / 0; }
        catch (Exception e) { exceptions.add(e); }
        try { ex[0] = "gfshdfh"; }
        catch (Exception e) { exceptions.add(e); }
        try { System.out.println(ex); }
        catch (Exception e) { exceptions.add(e); }
        try { float i = 1 / 0; }
        catch (Exception e) { exceptions.add(e); }
    }
}
