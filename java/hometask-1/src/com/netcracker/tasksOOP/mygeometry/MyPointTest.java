package com.netcracker.tasksOOP.mygeometry;

public class MyPointTest {
    public static void main(String[] args) {
        System.out.println("-------- 5. MyPoint: test -------");

        MyPoint point1 = new MyPoint(1.0, 1.0);
        System.out.println(point1.toString());
        System.out.println("Distance to (0,0) = " + point1.distance());
        System.out.println("Distance to (1,0) = " + point1.distance(1.0, 0.0));
        System.out.println("Distance to (3,1) = " + point1.distance(new MyPoint(3.0, 1.0)));

        System.out.println("---------------------------------\n\n");
    }
}
