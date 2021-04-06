package com.netcracker.sources.chapterFour;

import com.netcracker.sources.chapterTwo.Point;

public class Line extends Shape {
    private Point from, to;


    public Line(Point from, Point to) {
        super(new Point( (to.getX() + from.getX()) / 2, (to.getY() + from.getY()) / 2));
        this.from = new Point (from.getX(), from.getY());
        this.to = new Point (to.getX(), to.getY());
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }


    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Line{" +
                "from=" + from +
                ", to=" + to +
                ", center=" + center +
                '}';
    }
}
