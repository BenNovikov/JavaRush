package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    public static final int TRUCK = 0;
    public static final int SEDAN = 1;
    public static final int CABRIOLET = 2;

    protected static final int MAX_TRUCK_SPEED = 80;
    protected static final int MAX_SEDAN_SPEED = 120;
    protected static final int MAX_CABRIOLET_SPEED = 90;

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
            default: car = null;
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

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
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

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        int result = 0;
        if (canPassengersBeTransferred())
            result = numberOfPassengers;
        return result;
    }

    public abstract int getMaxSpeed();
}
