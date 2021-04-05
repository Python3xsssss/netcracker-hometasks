package com.netcracker.tests;

import  com.netcracker.sources.chapterTwo.Point;

public class PointTest {
    public static void main(String[] args) {
        System.out.println("----------- Point test -----------");

        Point point = new Point(1, 1);

        System.out.println("Point: " + point.toString());

        Point shifted = point.translate(1, 1);
        System.out.println("After translation: " + shifted.toString());

        Point scaled = shifted.scale(2.0);
        System.out.println("After scaling: " + scaled.toString());

        System.out.println("----------------------------------");
    }

}
