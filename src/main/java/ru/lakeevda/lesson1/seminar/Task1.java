package ru.lakeevda.lesson1.seminar;

/**
 * Реализуйте метод, принимающий в качестве аргументов целочисленный массив и некоторый допустимый минимум.
 * Если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки, иначе - длину массива.
 */

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};

        System.out.println(getLength(arr, 5));
    }

    public static int getLength (int[] arr, int min) {
        if (arr.length < min) return -1;
        else return arr.length;
    }
}
