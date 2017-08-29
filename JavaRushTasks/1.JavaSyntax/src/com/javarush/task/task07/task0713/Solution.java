package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList();

        try {
            for (int i = 0; i < 10; i++) arr.add(Integer.parseInt(reader.readLine()));
        } catch(IOException e) {

        }
        for (int i = arr.size() - 1; i >= 0; i--) System.out.println(arr.get(i));
    }
}
