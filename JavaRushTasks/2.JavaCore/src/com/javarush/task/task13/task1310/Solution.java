package com.javarush.task.task13.task1310;

/* 
Это кто там такой умный?
1. Класс CleverMan должен реализовывать подходящий ему интерфейс(Secretary или Boss).
2. Класс SmartGirl должен реализовывать подходящий ему интерфейс(Secretary или Boss).
3. Секретарь(Secretary) является человеком(Person).
4. Начальник(Boss) является человеком(Person), а также любит много работать(Workable).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface Workable {
        boolean wantsToGetExtraWork();
    }

    interface Secretary extends Person {
    }

    interface Boss extends Workable, Person {
    }

    class CleverMan implements Boss {
        public void use(Person person) {
            person.startToWork();
        }

        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl implements Secretary {
        public void use(Person person) {
        }

        public void startToWork() {
        }
    }
}
