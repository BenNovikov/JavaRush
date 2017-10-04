package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
//        System.out.println(Dish.allDishesToString());
//        List<Dish> dishes = new ArrayList<>();
//        try {
//            dishes = ConsoleHelper.getAllDishesForOrder();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(dishes);

        Tablet tablet = new Tablet(5);
        Cook firstCook = new Cook("Amigo");
        tablet.addObserver(firstCook);
        tablet.createOrder();

    }


}
