package com.netcracker.tasksOOP.mygeometry;

public class MyTriangleTest {
    public static void main(String[] args) {
        System.out.println("------ 6. MyTriangle: test ------");

        MyTriangle triangle1 = new MyTriangle(0, 0, 1, 1, 2, 0);

        System.out.println(triangle1.toString());
        System.out.println("Perimeter = " + triangle1.getPerimeter());
        System.out.println("Type: " + triangle1.getType());

        System.out.println("---------------------------------\n\n");
    }
}
