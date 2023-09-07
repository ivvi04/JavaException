package ru.lakeevda.lesson1.seminar;

import java.util.Scanner;

/**
 * Создайте boolean метод, который запросит у пользователя поля: login, password и confirm password
 * Логин должен содержать только символы: a, b, c, d, e, 0,1, _, если это не так нужно бросить RuntimeException с соответствующим сообщением.
 * Логин должен быть не меньше 4 и не больше 8 символов, если это не так нужно бросить RuntimeException с соответствующим сообщением.
 * Пароль должен быть не меньше 4 и не больше 8 символов и состоять только из цифр, если это не так нужно бросить RuntimeException с соответствующим сообщением.
 * Пароль и его повтор должны совпадать, если это не так нужно бросить RuntimeException с соответствующим сообщением.
 */

public class Task5 {
    public static void main(String[] args) {
        try {
            System.out.println(register());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean register() {
        System.out.println("Login: ");
        String login = prompt();

        System.out.println("Password: ");
        String password = prompt();

        System.out.println("Confirm Password: ");
        String confirmPassword = prompt();

        if (!login.matches("[abcde01_]{4,8}")) throw new RuntimeException("Некорректный логин");

        if (!password.matches("\\d{4,8}")) throw new RuntimeException("Некорректный пароль");

        if (password != confirmPassword) throw new RuntimeException("Пароли не совпадают");

        return true;
    }

    public static String prompt () {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
