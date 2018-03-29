package com.autocourses;

public class WrongEnteringException extends Exception {
    WrongEnteringException() {
        super("Неправильный формат ввода");
    }
}
