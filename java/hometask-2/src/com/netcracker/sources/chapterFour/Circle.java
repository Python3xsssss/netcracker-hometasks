package com.netcracker.sources.chapterFour;

import com.netcracker.sources.chapterTwo.Point;

public class Circle extends Shape {
    private double radius;


    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }


    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
