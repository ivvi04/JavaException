package ru.lakeevda.lesson3.homework.exceptions;

import java.io.IOException;

public class GenderException extends IOException {
    public GenderException(String message) {
        super(message);
    }
}
