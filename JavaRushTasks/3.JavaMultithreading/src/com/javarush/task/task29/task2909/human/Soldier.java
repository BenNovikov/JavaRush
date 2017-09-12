package com.javarush.task.task29.task2909.human;

/**
 * Created by Ben on 2017-09-11.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
