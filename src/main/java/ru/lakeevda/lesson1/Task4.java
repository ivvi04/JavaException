package ru.lakeevda.lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
 * Метод должен пройтись по каждому элементу и проверить что он не равен null. Реализуйте следующую логику:
 * 1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
 * 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */

public class Task4 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, null, 5, null, 6, 7};

        checkArray(arr);
    }

    public static final void checkArray(Integer[] arr) {
        List<Integer> listIndex = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) listIndex.add(i);
        }
        if (!listIndex.isEmpty()) System.out.println(listIndex.toString());
    }
}
