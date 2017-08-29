package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот.
Создать 10 объектов Cat.
Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public static ArrayList<Cat> cats  = new ArrayList<Cat>();

    public Cat() {
//        cats.add(this);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat();
            cats.add(cat);
        }
        printCats();
    }

    public static void printCats() {
        for (Cat cat: cats) System.out.println(cat);
    }
}
