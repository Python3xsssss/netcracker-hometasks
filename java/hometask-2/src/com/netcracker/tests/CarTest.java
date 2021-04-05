package com.netcracker.tests;

import  com.netcracker.sources.chapterTwo.Car;

public class CarTest {
    public static void main(String[] args) {
        System.out.println("----------- Car test -----------");

        Car car = new Car(5, 18);

        System.out.println("Initial values:");
        System.out.println("Distance: " + car.getX());
        System.out.println("Amount of gas: " + car.getGas());

        car.moveBy(18);
        System.out.println();
        System.out.println("VZHHHHHHHH!");
        System.out.println("Distance: " + car.getX());
        System.out.println("Amount of gas: " + car.getGas());

        car.fillTank(1);
        System.out.println();
        System.out.println("Fill the tank!");
        System.out.println("Distance: " + car.getX());
        System.out.println("Amount of gas: " + car.getGas());

        car.moveBy(18 * 50);
        System.out.println();
        System.out.println("VZHHHHHHHH!");
        System.out.println("Distance: " + car.getX());
        System.out.println("Amount of gas: " + car.getGas());
        System.out.println("The tank is empty!");

        System.out.println("--------------------------------");
    }
}
