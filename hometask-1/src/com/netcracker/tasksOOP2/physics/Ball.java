package com.netcracker.tasksOOP2.physics;

import static java.lang.Math.*;

public class Ball {
    private float x, y;
    private float xDelta, yDelta;
    private int radius;


    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * (float)cos(direction * Math.PI / 180.0);
        this.yDelta = speed * (-1) * (float)sin(direction / 180.0 * Math.PI);
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta *= -1;
    }

    public void reflectVertical() {
        yDelta *= -1;
    }

    @Override
    public String toString() {
        return "Ball{(" + x + "," + y + "), speed=(" + xDelta + "," + yDelta + ")}";
    }
}
