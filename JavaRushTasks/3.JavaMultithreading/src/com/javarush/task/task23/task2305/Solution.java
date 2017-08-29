package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];
        Solution temp = new Solution();
        temp.innerClasses[0] = temp.new InnerClass();
        temp.innerClasses[1] = temp.new InnerClass();
        solution[0] = temp;
        temp = new Solution();
        temp.innerClasses[0] = temp.new InnerClass();
        temp.innerClasses[1] = temp.new InnerClass();
        solution[1] = temp;
        return solution;
    }

    public static void main(String[] args) {

    }
}
