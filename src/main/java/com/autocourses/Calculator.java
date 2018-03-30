package com.autocourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, Calculable> operation = new HashMap<>();

    public Calculator() {
        operation.put("+", new Addition());
        operation.put("-", new Subtraction());
        operation.put("*", new Multiplication());
        operation.put("/", new Division());
        operation.put("log", new Logarithm());
        operation.put("sqrt", new Root());
        operation.put("^", new Degree());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение через пробел: ");
        String line = reader.readLine();
        String[] arr = line.split(" ");
        double a, b;
        String operation;
        try {
            if (arr.length == 3) {
                a = Double.parseDouble(arr[0]);
                b = Double.parseDouble(arr[2]);
                operation = arr[1];
            } else {
                throw new WrongEnteringException();
            }
            System.out.print("= ");
            Calculator calculator = new Calculator();
            try {
                System.out.println(calculator.calculate(a, b, operation));
            } catch (WrongOperationException e) {
                System.out.println("Такая операция не поддерживается");
            }
        } catch (WrongEnteringException e) {
            System.out.println("Неправильный формат ввода");
        } catch (NumberFormatException e) {
            System.out.println("Операции с буквами не поддерживаются");
        }
    }

    public double calculate(double val1, double val2, String operator) throws WrongOperationException {
        Calculable operation = getOperationFor(operator);
        if (operation == null) {
            throw new WrongOperationException();
        }
        return operation.resultFor(val1, val2);
    }

    private Calculable getOperationFor(String operator) {
        return operation.get(operator);
    }
}
