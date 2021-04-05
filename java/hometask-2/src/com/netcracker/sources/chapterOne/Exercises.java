package com.netcracker.sources.chapterOne;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Exercises {
    public static void firstEx(int number) {
        System.out.println("Decimal : " + number);
        System.out.println("Binary: " + Integer.toString(number, 2));
        System.out.println("Octal: " + Integer.toString(number, 8));
        System.out.println("Hexadecimal: " + Integer.toString(number, 16));
        System.out.println("Reciprocal in hexadecimal: " + Long.toString(Double.doubleToRawLongBits(1.0 / number), 16));
    }

    public static void secondEx(int angle) {
        int angleNorm = angle % 360;
        if (angleNorm < 0) {
            angleNorm += 360;
        }
        System.out.println("Angle: " + angle);
        System.out.println("Normalised using %: " + angleNorm);
        System.out.println("Normalised using floorMod: " + Math.floorMod(angle, 360));
    }

    public static void thirdEx(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("a = " + a + " b = " + b + " c = " + c);
        System.out.println("Max with conditionals: " + max);
        System.out.println("Max with MathMax: " + Math.max(a, Math.max(b, c)));
    }

    public static void fourthEx() {
        System.out.println("Min Positive Double: " + Math.nextUp(0.0d));
        System.out.println("Max Positive Double: " + Math.nextDown(Double.POSITIVE_INFINITY));
    }

    private static BigInteger factorial(int number) {
        if (number > 0)
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        return BigInteger.valueOf(1);
    }

    public static void fifthEx(int number) {
        System.out.println(number + "! = " + factorial(number));
    }

    public static void thirteenthEx() {
        ArrayList<Integer> lotteryList = new ArrayList<Integer>();
        for (int i = 1; i < 50; i++) {
            lotteryList.add(i);
        }

        ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            int newNumber = (int) (Math.random() * (49 - i));
            lotteryNumbers.add(lotteryList.get(newNumber));
            lotteryList.remove(newNumber);
        }

        Collections.sort(lotteryNumbers);
        System.out.print("New lucky number sequence iiis...");
        for (int i : lotteryNumbers)
            System.out.print(" " + i);
        System.out.println();
    }
}
