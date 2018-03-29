package com.autocourses;

public class Logarithm implements Calculable {
    public double resultFor(double firstNum, double secondNum) {
        return Math.log(secondNum) / Math.log(firstNum);
    }
}
