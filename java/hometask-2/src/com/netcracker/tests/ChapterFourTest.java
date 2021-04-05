package com.netcracker.tests;

public class ChapterFourTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPoint a = new MyPoint(0, 0);
        MyPoint b = new MyPoint(1, 1);
        Line abc = new Line(a, b);
        Line acc = abc.clone();
        System.out.println(acc.getFrom());
    }
}
