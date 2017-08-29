package com.javarush.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ben on 2017-08-15.
 */
public class DaysBetweenDates {
    public static void main(String[] args) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = "31 12 1969";
        String inputString2 = "14 10 1970";

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("Days: " + days);
            System.out.println(Long.toBinaryString(days));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(Boolean.toString(!(true || true)) + " " + Boolean.toString(!true && !true));
    }
}
