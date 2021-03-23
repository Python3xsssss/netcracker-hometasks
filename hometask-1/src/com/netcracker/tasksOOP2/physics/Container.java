package com.netcracker.tasksOOP2.physics;

public class Container {
    private int x1, y1, x2, y2;


    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }


    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    boolean collides(Ball ball) {
        float top = ball.getY() + ball.getRadius(), bottom = ball.getY() - ball.getRadius();
        float left = ball.getX() + ball.getRadius(), right = ball.getX() - ball.getRadius();

        return (left >= x2 || right <= x1 || top >= y2 || bottom <= y1);
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 +
                "," + y1 +
                "), (" + x2 +
                "," + y2 +
                ")}";
    }
}
