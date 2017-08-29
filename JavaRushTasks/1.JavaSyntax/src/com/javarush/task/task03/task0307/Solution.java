package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Zerg current = new Zerg();
            current.name = current.getClass().getName() + "#" + i;
//            System.out.println(current.name);
        }
        for(int i = 0; i < 5; i++) {
            Protoss current = new Protoss();
            current.name = current.getClass().getName() + "#" + i;
//            System.out.println(current.name);
        }
        for(int i = 0; i < 12; i++) {
            Terran current = new Terran();
            current.name = current.getClass().getName() + "#" + i;
//            System.out.println(current.name);
        }
    }

    public static class Zerg {
        public String name = "nam";
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
