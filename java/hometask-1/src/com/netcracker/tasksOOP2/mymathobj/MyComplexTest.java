package com.netcracker.tasksOOP2.mymathobj;

public class MyComplexTest {
    public static void main(String[] args) {
        System.out.println("------- 7. MyComplex: test ------");

        MyComplex comp1 = new MyComplex(1.0, 1.0);
        System.out.println(comp1.toString());
        System.out.println("Real? " + comp1.isReal() + "! Imaginary? " + comp1.isImaginary() + "!");
        System.out.println("Magnitude = " + comp1.magnitude());
        System.out.println("Argument = " + comp1.argument());
        System.out.println("(1 + i) + (2 + 2i) = " + comp1.addNew(new MyComplex(2.0, 2.0)).toString());
        System.out.println("(1 + i) - (1 - i) = " + comp1.subtractNew(new MyComplex(1.0, -1.0)).toString());
        System.out.println("(1 + i) * (2 + i) = " + comp1.multiply(new MyComplex(2.0, 1.0)).toString());
        System.out.println("(1 + 3i) / (1 - i) = " + comp1.divide(new MyComplex(1.0, -1.0)).toString());

        System.out.println("---------------------------------\n\n");
    }
}
