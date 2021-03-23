package com.netcracker.tasksOOP2.mymathobj;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

public class MyPolynomial {
    private double[] coeffs;


    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }


    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (out.length() == 0) {
                    out += ((coeffs[i] < 0) ? "- " : "");
                } else {
                    out += ((coeffs[i] < 0) ? "- " : "+ ");
                }
                out += abs(coeffs[i]) + ((i == 0) ? "" : "*x") + ((i <= 1) ? " " : "^" + i + " ");
            }

        }

        return out;
    }

    public double evaluate(double x) {
        double out = 0, var = 1;

        for (double coeff : coeffs) {
            out += coeff * var;
            var *= x;
        }

        return out;
    }

    public MyPolynomial add(MyPolynomial right) {
        int i = 0;
        int maxLen = max(this.coeffs.length, right.coeffs.length);
        MyPolynomial out = new MyPolynomial(new double[maxLen]);

        while (i < this.coeffs.length && i < right.coeffs.length) {
            out.coeffs[i] = this.coeffs[i] + right.coeffs[i];
            i++;
        }

        for(; i < maxLen; i++) {
            out.coeffs[i] = (this.coeffs.length > right.coeffs.length) ? this.coeffs[i] : right.coeffs[i];
        }

        return out;
    }

    public MyPolynomial multiply (MyPolynomial right) {
        MyPolynomial out = new MyPolynomial(new double[this.coeffs.length + right.coeffs.length - 1]); // default array initialisation with zeros
        for (int i = 0; i < this.coeffs.length; i++)
            for (int j = 0; j < right.coeffs.length; j++)
                out.coeffs[i + j] += this.coeffs[i] * right.coeffs[j];

        return out;
    }
}
