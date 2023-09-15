package ru.lakeevda.lesson3.seminar;

import java.io.FileReader;
import java.io.IOException;

/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */

public class Task3 {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println(counter.getCounter());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Counter implements AutoCloseable {

    private boolean closed = false;
    int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void add () throws IOException {
        if(closed) throw new IOException("Resource is closed");
        counter++;
    }

    @Override
    public void close() throws Exception {
        closed = true;
    }
}