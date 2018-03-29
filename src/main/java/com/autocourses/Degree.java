package com.autocourses;

public class Degree implements Calculable {
    public double resultFor(double firstNum, double secondNum) {
        return Math.pow(firstNum, secondNum);
    }
}
