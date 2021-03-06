package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();
    private BloodGroup bloodGroup;
    protected Size size;

    public class Size {
        public int height;
        public int weight;
    }

    public void setBloodGroup(BloodGroup group) {
        bloodGroup = group;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild (Human child) {
        if (child != null)
            children.add(child);
    }

    public void removeChild (Human child) {
        if (child != null && children.contains(child))
            children.remove(child);
    }

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void live() {}

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public String getPosition() {
        return "Человек";
    }
}
