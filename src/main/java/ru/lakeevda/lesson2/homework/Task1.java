package ru.lakeevda.lesson2.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    System.out.println("Введите дробное число: ");
                    float fNumber = Float.parseFloat(bufferedReader.readLine());
                    System.out.printf("Число равно: %f", fNumber);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}