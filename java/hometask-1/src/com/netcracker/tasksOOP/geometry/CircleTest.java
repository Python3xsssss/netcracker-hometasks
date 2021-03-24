package com.netcracker.tasksOOP.geometry;

public class CircleTest {
    public static void main(String[] args) {
        System.out.println("-------- 1. Circle: test --------");

        Circle cir1 = new Circle(2.0, "green");
        System.out.println(cir1.toString());
        System.out.println("Area = " + cir1.getArea());

        System.out.println("---------------------------------\n\n");
    }

    
}
