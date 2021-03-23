package com.netcracker.tasksOOP.company;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("------- 3. Employee: test -------");

        Employee empl1 = new Employee(1234, "Elon", "Musk", 1000000);
        System.out.println(empl1.toString());
        System.out.println("Full name: " + empl1.getName());
        System.out.println("Annual salary = " + empl1.getAnnualSalary());
        empl1.raiseSalary(10);
        System.out.println("Salary increased by 10%!!!");
        System.out.println("Annual salary = " + empl1.getAnnualSalary());

        System.out.println("---------------------------------\n\n");
    }
}
