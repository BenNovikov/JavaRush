package com.javarush.task.task29.task2909.car;

import java.util.Date;

public class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        Car car;
        switch (type) {
            case 0 : car = new Truck(numberOfPassengers);
                break;
            case 1 : car = new Sedan(numberOfPassengers);
                break;
            case 2 : car = new Cabriolet(numberOfPassengers);
                break;
            default: car = new Car(type, numberOfPassengers);
        }
        return car;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) {
            throw new Exception("Illegal Number of Liters");
        }
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        return isSummer(date, summerStart, summerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public int getMaxSpeed() {
        if (type == TRUCK)
            return 80;
        if (type == SEDAN)
            return 120;
        return 90;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return (date.after(summerStart) && date.before(summerEnd));
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }
}