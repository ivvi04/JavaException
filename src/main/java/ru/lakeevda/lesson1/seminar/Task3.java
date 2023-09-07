package ru.lakeevda.lesson1.seminar;

/**
 * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
 * Необходимо посчитать и вернуть сумму элементов этого массива. При этом накладываем на метод 2 ограничения:
 * метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
 * Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */

public class Task3 {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}};

        try {
            System.out.println(getSumElements(ints));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSumElements(int[][] ints) {
        int result = 0;

        for (int i = 0; i < ints.length; i++) {
            if (ints.length != ints[0].length) throw new RuntimeException("Массив не квадратный");
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] < 0 || ints[i][j] > 1) throw new RuntimeException("Значения должно быть 0 или 1");
                result += ints[i][j];
            }
        }

        return result;
    }
}
