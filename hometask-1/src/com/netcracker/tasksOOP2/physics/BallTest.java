package com.netcracker.tasksOOP2.physics;

public class BallTest {
    public static void main(String[] args) {
        System.out.println("--------- 9. Ball: test ---------");

        Container cont1 = new Container(1, 1, 50, 50);
        System.out.println(cont1.toString());

        Ball ball1 = new Ball(3.0f, 3.0f, 1, 5, 180);
        System.out.println(ball1.toString());

        System.out.println("Collides? " + cont1.collides(ball1));
        System.out.println("Moving one step forward...");
        ball1.move();
        System.out.println(ball1.toString());
        System.out.println("Collides? " + cont1.collides(ball1));
        ball1.reflectHorizontal();
        System.out.println(ball1.toString());
        System.out.println("Moving one step forward...");
        ball1.move();
        System.out.println(ball1.toString());
        System.out.println("Collides? " + cont1.collides(ball1));

        System.out.println("---------------------------------\n\n");
    }
}
