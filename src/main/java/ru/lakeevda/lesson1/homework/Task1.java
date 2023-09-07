package ru.lakeevda.lesson1.homework;

public class Task1 {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        throw new ArithmeticException();
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        throw new NumberFormatException();
    }
}