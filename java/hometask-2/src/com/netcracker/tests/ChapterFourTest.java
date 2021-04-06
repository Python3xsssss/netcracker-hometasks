package com.netcracker.tests;

import com.netcracker.sources.chapterTwo.Point;
import com.netcracker.sources.chapterFour.*;

public class ChapterFourTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("--------- Chapter 4 test ---------");

        Point from = new Point(0, 0);
        Point to = new Point(1, 0);

        Line line = new Line(from, to);
        Line copyLine = line.clone();
        System.out.println("Line: " + line.toString());
        System.out.println("Copied line: " + copyLine.toString());

        System.out.println();
        Rectangle rec = new Rectangle(from, 2, 2);
        Rectangle copyRec = rec.clone();
        System.out.println("Rectangle: " + rec.toString());
        System.out.println("Copied rectangle: " + copyRec.toString());

        System.out.println();
        Circle circle = new Circle(from, 2);
        Circle copyCircle = circle.clone();
        System.out.println("Circle: " + circle.toString());
        System.out.println("Copied circle: " + copyCircle.toString());

        System.out.println("----------------------------------");
    }
}
