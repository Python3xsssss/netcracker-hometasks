package com.netcracker.sources.chapterFour;

import com.netcracker.sources.chapterTwo.Point;

public class Rectangle extends Shape{
    private Point topLeft;
    double width, height;

    public Rectangle(Point topLeft, double width, double height) {
        super(new Point(topLeft.getX() + width / 2, topLeft.getY() + height / 2));
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.width = width;
        this.height = height;
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }


    public Point getTopLeft() {
        return topLeft;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeft=" + topLeft +
                ", width=" + width +
                ", height=" + height +
                ", center=" + center +
                '}';
    }
}
