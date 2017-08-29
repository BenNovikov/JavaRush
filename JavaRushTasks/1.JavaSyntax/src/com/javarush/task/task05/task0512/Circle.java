package com.javarush.task.task05.task0512;

public class Circle {
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private int color;

    public void initialize(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerY = radius;
    }
    public void initialize(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerY = radius;
        this.width = width;
    }
    public void initialize(int centerX, int centerY, int radius, int width, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerY = radius;
        this.width = width;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
