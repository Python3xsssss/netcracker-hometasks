package com.netcracker.tests;

import  com.netcracker.sources.chapterOne.Exercises;

public class ExercisesTest {
    public static void testFirst() {
        System.out.println("------- 1st exercise test -------");

        Exercises.firstEx(1);
        System.out.println();
        Exercises.firstEx(2);
        System.out.println();
        Exercises.firstEx(10);

        System.out.println("---------------------------------");
    }

    public static void testSecond() {
        System.out.println("------- 2nd exercise test -------");

        Exercises.secondEx(180);
        System.out.println();
        Exercises.secondEx(369);
        System.out.println();
        Exercises.secondEx(-369);

        System.out.println("---------------------------------");
    }

    public static void testThird() {
        System.out.println("------- 3rd exercise test -------");

        Exercises.thirdEx(180, 360, 360);
        System.out.println();
        Exercises.thirdEx(369, 0, 0);
        System.out.println();
        Exercises.thirdEx(-369, 15, 16);

        System.out.println("---------------------------------");
    }

    public static void testFourth() {
        System.out.println("------- 4th exercise test -------");

        Exercises.fourthEx();

        System.out.println("---------------------------------");
    }

    public static void testSixth() {
        System.out.println("------- 6th exercise test -------");

        Exercises.fifthEx(0);
        System.out.println();
        Exercises.fifthEx(1);
        System.out.println();
        Exercises.fifthEx(5);
        System.out.println();
        Exercises.fifthEx(1000);

        System.out.println("---------------------------------");
    }

    public static void testThirteen() {
        System.out.println("------- 13th exercise test -------");

        Exercises.thirteenthEx();
        System.out.println();
        Exercises.thirteenthEx();
        System.out.println();
        Exercises.thirteenthEx();

        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        testFirst();
        testSecond();
        testThird();
        testFourth();
        testSixth();
        testThirteen();
    }
}
