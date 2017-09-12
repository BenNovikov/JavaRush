package com.javarush.task.task29.task2909.car;

/**
 * Created by Ben on 2017-09-12.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
