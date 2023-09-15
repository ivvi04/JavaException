package ru.lakeevda.lesson3.homework.exceptions;

import java.io.IOException;

public class StringException extends IOException {
    public StringException(String message) {
        super(message);
    }
}
