package com.netcracker.sources.chapterTwo;

public final class Point {
    private double x, y;

    public Point() {
        x = 0.0d;
        y = 0.0d;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double shiftX, double shiftY) {
        return new Point(x + shiftX, y + shiftY);
    }

    public Point scale(double scaleBy) {
        return new Point(x * scaleBy, y * scaleBy);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}