package com.netcracker.sources.chapterFour;

import com.netcracker.sources.chapterTwo.Point;

public abstract class Shape implements Cloneable {
    protected Point center;


    public Shape(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }


    public Point getCenter() {
        return center;
    }

    public void moveBy(double dx, double dy) {
        center.translate(dx, dy);
    }
}
