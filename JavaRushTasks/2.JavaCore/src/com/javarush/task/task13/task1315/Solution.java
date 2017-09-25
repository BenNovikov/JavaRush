package com.javarush.task.task13.task1315;

/* 
1. Класс Cat должен быть объявлен внутри класса Solution.
2. Класс Dog должен быть объявлен внутри класса Solution.
3. Класс Mouse должен быть объявлен внутри класса Solution.
4. Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
5. Мышь(Mouse) может передвигаться и может быть съедена.
6. Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public class Mouse implements Movable, Eatable {
        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }
    }

    public class Cat implements Movable, Eat, Eatable {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }

        @Override
        public void eaten() {

        }
    }

    public class Dog implements Movable, Eat {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
}