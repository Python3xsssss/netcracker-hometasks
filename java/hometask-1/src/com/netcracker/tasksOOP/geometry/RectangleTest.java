package com.netcracker.tasksOOP.geometry;

public class RectangleTest {
    public static void main(String[] args) {
        System.out.println("------- 2. Rectangle: test ------");

        Rectangle rect1 = new Rectangle(2.0f, 4.0f);
        System.out.println(rect1.toString());
        System.out.println("Perimeter = " + rect1.getPerimeter());
        System.out.println("Area = " + rect1.getArea());

        System.out.println("---------------------------------\n\n");
    }
}
