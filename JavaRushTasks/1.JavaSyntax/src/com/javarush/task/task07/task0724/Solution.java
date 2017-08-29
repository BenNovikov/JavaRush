package com.javarush.task.task07.task0724;

/* 
Семейная перепись
имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
*/

public class Solution {
    public static void main(String[] args) {
        Human gma1 = new Human("Ann", false, 64);
        Human gma2 = new Human("Zoe", false, 62);
        Human gpa1 = new Human("John", true, 66);
        Human gpa2 = new Human("Mark", true, 67);
        Human mama = new Human("Belinda", false, 38, gpa1, gma1);
        Human papa = new Human("Josh", true, 40, gpa2, gma2);
        Human son1 = new Human("Ike", true, 20, papa, mama);
        Human son2 = new Human("Mike", true, 16, papa, mama);
        Human son3 = new Human("Spike", true, 12, papa, mama);

        System.out.println(gma1);
        System.out.println(gpa1);
        System.out.println(gma2);
        System.out.println(gpa2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this(name, sex, age, null, null);
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















