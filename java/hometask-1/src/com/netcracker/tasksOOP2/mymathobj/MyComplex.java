package com.netcracker.tasksOOP2.mymathobj;

import static java.lang.Math.*;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;


    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public MyComplex(MyComplex another) {
        this.real = another.real;
        this.imag = another.imag;
    }


    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }

    public boolean equals(MyComplex another) {
        return (this.real == another.real && this.imag == another.imag);
    }

    public double magnitude() {
        return sqrt(real * real + imag * imag);
    }

    public double argument() {
        return atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;

        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;

        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        this.real = (this.real * right.real) - (this.imag * right.imag);
        this.imag = (this.imag * right.real) + (this.real * right.imag);

        return this;
    }

    public MyComplex divide(MyComplex right) {
        if (right.equals(0, 0)) {
            throw new IllegalArgumentException("Argument 'right' is 0");
        }

        this.real = ((this.real * right.real) + (this.imag * right.imag)) / (right.real * right.real + right.imag * right.imag);
        this.imag = ((this.imag * right.real) - (this.real * right.imag)) / (right.real * right.real + right.imag * right.imag);

        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(1 * this.real, (-1) * this.imag);
    }
}
