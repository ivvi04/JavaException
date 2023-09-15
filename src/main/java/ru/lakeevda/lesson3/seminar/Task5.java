package ru.lakeevda.lesson3.seminar;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 * с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 2. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task5 {
    static String[][] arr = new String[][]{
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"}
    };

    public static void main(String[] args) {
        try {
            System.out.println(sum2d(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

//    private static boolean isNotSquareArray(String[][] arr) {
//        if (arr.length != 3) return true;
//        for(String[] elem : arr) {
//            if (elem.length != arr.length) return true;
//        }
//        return false;
//    }

    public static double sum2d(String[][] arr) {
        double sum = 0;
        if (arr.length != 3) throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 3) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Double.parseDouble(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Неверный размер массива");
    }
}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j, String elem) {
        super(String.format("[%s][%s] = %s - ошибка числа", i, j, elem));
    }
}