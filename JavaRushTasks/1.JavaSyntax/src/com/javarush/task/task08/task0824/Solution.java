package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human kid1 = new Human(true, new ArrayList<>());
        Human kid2 = new Human(true, new ArrayList<>());
        Human kid3 = new Human(false, new ArrayList<>());
        ArrayList<Human> kids = new ArrayList<>();
        kids.add(kid1);
        kids.add(kid2);
        kids.add(kid3);
        Human dad = new Human(true, kids);
        ArrayList<Human> dada = new ArrayList<>();
        dada.add(dad);
        Human mom = new Human(false, kids);
        ArrayList<Human> moma = new ArrayList<>();
        moma.add(mom);
        Human gpa1 = new Human(true, dada);
        Human gma1 = new Human(false, dada);
        Human gpa2 = new Human(true, moma);
        Human gma2 = new Human(false, moma);
        ArrayList<Human> everyone = new ArrayList<>(kids);
        everyone.add(dad);
        everyone.add(mom);
        everyone.add(gpa1);
        everyone.add(gma1);
        everyone.add(gpa2);
        everyone.add(gma2);
        for (Human each: everyone) {
            System.out.println(each);
        }
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> kids;

        public Human(String name, boolean sex, int age, ArrayList<Human> kids) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.kids = kids;
        }

        public Human(boolean sex, ArrayList<Human> kids) {
            this("Unknown Name", sex, 33, kids);
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.kids.size();
            if (childCount > 0) {
                text += ", дети: " + this.kids.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.kids.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
