package com.netcracker;

import com.netcracker.tasksOOP.company.EmployeeTest;
import com.netcracker.tasksOOP.company.publishing.BookTest;
import com.netcracker.tasksOOP.geometry.CircleTest;
import com.netcracker.tasksOOP.geometry.RectangleTest;
import com.netcracker.tasksOOP.mygeometry.MyPointTest;
import com.netcracker.tasksOOP.mygeometry.MyTriangleTest;

import com.netcracker.tasksOOP2.mymathobj.MyComplexTest;
import com.netcracker.tasksOOP2.mymathobj.MyPolynomialTest;
import com.netcracker.tasksOOP2.physics.BallTest;

public class Main {

    public static void main(String[] args) {
        System.out.println("------ Let the tests begin ------\n\n");

        CircleTest.main(args);
        RectangleTest.main(args);
        EmployeeTest.main(args);
        BookTest.main(args);
        MyPointTest.main(args);
        MyTriangleTest.main(args);
        MyComplexTest.main(args);
        MyPolynomialTest.main(args);
        BallTest.main(args);

        System.out.println("------- The end of tests --------");
    }
}
