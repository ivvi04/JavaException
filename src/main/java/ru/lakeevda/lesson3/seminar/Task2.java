package ru.lakeevda.lesson3.seminar;

/**
 Создайте метод doSomething(), который может быть источником одного
 из типов checked exceptions(тело самого метода прописывать не обязательно).
 Вызовите этот метод из main и обработайте в нем исключение, которое вызвал
 метод doSomething().
 */
public class Task2 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doSomething () throws Exception {
        throw new Exception();
    }
}
