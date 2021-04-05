package com.netcracker.tests;

import com.netcracker.sources.chapterThree.Employee;
import com.netcracker.sources.chapterThree.Measurable;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("--------- Employee test ---------");

        Measurable emp1 = new Employee("Anton", 1);
        Measurable emp2 = new Employee("Igor", 2);
        Measurable emp3 = new Employee("Ruslan", 3);
        Measurable employees[] = new Employee[3];

        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = emp3;

        System.out.println("Average salary: " + Employee.average(employees));
        System.out.println("Employee with the largest salary: " + Employee.largest(employees).getMeasure());

        System.out.println("---------------------------------");
    }
}
