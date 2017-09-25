package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private String name;
        private boolean sex;
        private int heightCm;
        private double weigthKg;
        private int iQ;

        public Human (int age, String name, boolean sex, int heightCm, double weigthKg, int iQ) {
            this.age = age;
            this.name = name;
            this.sex = sex;
            this.heightCm = heightCm;
            this.weigthKg = weigthKg;
            this.iQ = iQ;
        }
        public Human (int age, String name, boolean sex, int heightCm, double weigthKg) {
            this(age, name, sex, heightCm, weigthKg, 80);
        }
        public Human (int age, String name, boolean sex, int heightCm) {
            this(age, name, sex, heightCm, 50, 80);
        }
        public Human (int age, String name, boolean sex) {
            this(age, name, sex, 160, 50, 80);
        }
        public Human (int age, String name) {
            this(age, name, true, 160, 50, 80);
        }
        public Human (int age) {
            this(age, "John Doe", true, 160, 50, 80);
        }
        public Human () {
            this(33, "John Doe", true, 160, 50, 80);
        }
        public Human (String name, boolean sex, int heightCm, double weigthKg) {
            this(33, name, sex, heightCm, weigthKg, 80);
        }
        public Human (boolean sex, int heightCm, double weigthKg) {
            this(33, "John Doe", sex, heightCm, weigthKg, 80);
        }
        public Human (String name, boolean sex) {
            this(33, name, sex, 160, 50, 80);
        }
    }
}
