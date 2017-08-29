package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Все переменные должны быть проинициализированы.
5. Программа должна выводить данные на экран.
6. Вывод должен соответствовать заданию.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try {
            SimpleDateFormat formatInput = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Date date = formatInput.parse(reader.readLine());
            System.out.println(format.format(date).toUpperCase());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Input date format: MM/dd/yyyy");
            main(args);
        }
    }
}
