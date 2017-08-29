package com.javarush.task.task05.task0526;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String line;
        while(true) {
            line = reader.readLine();
            try {
                sum += Integer.parseInt(line);
            } catch(NumberFormatException e) {
                if (line.equals("сумма")) break;
            }
        }
        System.out.println(sum);
    }
}

//            } catch(NullPointerException e) {
//                System.out.println("NullPointerException");
//                if (line.equals("сумма")) break;