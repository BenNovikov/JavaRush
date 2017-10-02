package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        ConsoleHelper.writeMessage("Make your choice, please. Enter 'exit' to finish: ");
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        boolean ready = false;
        while (!ready) {
            String selectedDish = ConsoleHelper.readString().toLowerCase();
            selection:
            switch (selectedDish) {
                case "exit" :
                    ready = true;
                    break;
                case "" :
                    ConsoleHelper.writeMessage("Nothing selected!");
                    break;
                default:
                    for (Dish dish : Dish.values()) {
                        if (dish.name().toLowerCase().equals(selectedDish)) {
                            dishes.add(dish);
                            break selection;
                        }
                    }
                    ConsoleHelper.writeMessage("Wrong selection!");
            }
        }

        return dishes;
    }
}
