package com.netcracker;

import com.netcracker.tests.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ Let the tests begin ------\n\n");

        ExercisesTest.main(args);
        CarTest.main(args);
        PointTest.main(args);
        EmployeeTest.main(args);
        try {
            ChapterFourTest.main(args);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("------- The end of tests --------");
    }
}
