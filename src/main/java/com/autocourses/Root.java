package com.autocourses;

public class Root implements Calculable {
    public double resultFor(double firstNum, double secondNum) {
        return Math.pow(secondNum, 1 / firstNum);
    }
}
