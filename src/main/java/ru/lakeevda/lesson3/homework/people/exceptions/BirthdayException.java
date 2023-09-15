package ru.lakeevda.lesson3.homework.people.exceptions;

import java.io.IOException;

public class BirthdayException extends IOException {
    public BirthdayException(String message) {
        super(message);
    }
}
