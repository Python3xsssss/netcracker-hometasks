package com.netcracker.tasksOOP2.mymathobj;

public class MyPolynomialTest {
    public static void main(String[] args) {
        System.out.println("----- 8. MyPolynomial: test -----");

        MyPolynomial pol1 = new MyPolynomial(new double []{1, 2, 3});
        MyPolynomial pol2 = new MyPolynomial(new double []{1, 2, 3, 4, 5});

        System.out.println("Polynomial 1: " + pol1.toString());
        System.out.println("Polynomial 2: " + pol2.toString());

        MyPolynomial sum = pol1.add(pol2);
        MyPolynomial mul = pol1.multiply(pol2);

        System.out.println("Sum: " + sum.toString());
        System.out.println("Mul: " + mul.toString());

        System.out.println("---------------------------------\n\n");
    }
}
