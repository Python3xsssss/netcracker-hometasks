package com.netcracker.sources.chapterFour;

public class Circle extends Shape{
    private double radius;


    public Circle(MyPoint center, double radius) {
        super(new MyPoint(center.getX(), center.getY()));
        this.radius = radius;
    }


    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    public double getRadius() {
        return radius;
    }
}
