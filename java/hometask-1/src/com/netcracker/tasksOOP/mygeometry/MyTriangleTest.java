package com.netcracker.tasksOOP.mygeometry;

public class MyTriangleTest {
    public static void main(String[] args) {
        System.out.println("------ 6. MyTriangle: test ------");

        MyPoint point1 = new MyPoint(0, 0);
        MyPoint point2 = new MyPoint(1, 1);
        MyPoint point3 = new MyPoint(0, 2);

        MyTriangle triangle1 = new MyTriangle(point1, point2, point3);

        System.out.println(triangle1.toString());
        System.out.println("Perimeter = " + triangle1.getPerimeter());
        System.out.println("Type: " + triangle1.getType());

        point1.setX(2);
        point1.setY(0);

        System.out.println(triangle1.toString());
        System.out.println("Perimeter = " + triangle1.getPerimeter());
        System.out.println("Type: " + triangle1.getType());

        System.out.println("---------------------------------\n\n");
    }
}
