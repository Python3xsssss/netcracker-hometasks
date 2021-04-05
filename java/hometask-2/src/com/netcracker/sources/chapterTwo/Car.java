package com.netcracker.sources.chapterTwo;

public class Car {
    private double x = 0;
    private double gas;
    private final double efficiency;


    public Car(double gas, double efficiency) {
        this.gas = gas;
        this.efficiency = efficiency;
    }


    public double getX() {
        return x;
    }

    public double getGas() {
        return gas;
    }

    public void moveBy(double shiftX) {
        if (gas < shiftX / efficiency) {
            x += gas * efficiency;
            gas = 0;
        }
        else {
            x += shiftX;
            gas -= shiftX / efficiency;
        }
    }

    public void fillTank(double inpGas) {
        gas += inpGas;
    }
}
