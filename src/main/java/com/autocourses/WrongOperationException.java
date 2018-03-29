package com.autocourses;

public class WrongOperationException extends Exception {
    WrongOperationException() {
        super("Такая операция не поддерживается");
    }
}
