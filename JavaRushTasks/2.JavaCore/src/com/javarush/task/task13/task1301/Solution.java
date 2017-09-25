package com.javarush.task.task13.task1301;

/* 
Пиво
1. Класс Beer должен реализовывать(implements) интерфейс Alcohol.
2. Класс Beer не должен реализовывать интерфейс Drink напрямую(только опосредованно через Alcohol)
3. В классе Beer должны быть реализованы все методы интерфейса Alcohol.
4. В классе Beer должны быть реализованы все методы интерфейса Drink.
5. Метод isReadyToGoHome должен возвращать значение переменной READY_TO_GO_HOME.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drink {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class Beer implements Alcohol {

        @Override
        public boolean isReadyToGoHome() {
            return READY_TO_GO_HOME;
        }

        @Override
        public void askMore(String message) {

        }

        @Override
        public void sayThankYou() {

        }

        @Override
        public void sleepOnTheFloor() {

        }
    }
}