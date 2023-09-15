package ru.lakeevda.lesson3.homework.exceptions;

import java.io.IOException;

public class PhoneException extends IOException {
    public PhoneException(String message) {
        super(message);
    }
}
