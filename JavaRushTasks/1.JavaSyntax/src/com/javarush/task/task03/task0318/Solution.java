package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Years: ");
        int years = Integer.parseInt(reader.readLine());
        System.out.print("Name: ");
        String name = reader.readLine();

        System.out.print(name + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}
