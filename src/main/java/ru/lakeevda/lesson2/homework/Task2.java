package ru.lakeevda.lesson2.homework;

public class Task2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d = 0;
        try {
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
