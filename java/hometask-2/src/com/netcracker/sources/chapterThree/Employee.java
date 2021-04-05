package com.netcracker.sources.chapterThree;

public class Employee implements Measurable {
    private String name;
    private double salary;


    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }


    public void setSalary(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects) {
        double avg = 0.0d;
        for (Measurable obj : objects) {
            avg += obj.getMeasure();
        }
        return avg / (double) objects.length;
    }

    public static Measurable largest(Measurable[] objects) {
        double max = 0.0d;
        Measurable objMax = objects[0];

        for (Measurable obj: objects) {
            if (obj.getMeasure() > max) {
                max = (obj.getMeasure());
                objMax = obj;
            }
        }

        return objMax;
    }

    public String getName() {
        return name;
    }
}


