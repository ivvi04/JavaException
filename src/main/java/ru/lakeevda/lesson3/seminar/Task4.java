package ru.lakeevda.lesson3.seminar;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Task4 {
    public static void main(String[] args) {
//        devide(3, 0);
        try {
            readFile("123");
        } catch (NonExistedFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int devide(int x, int y) {
        if (y == 0) throw new DivideByZeroException();
        return x / y;
    }

    public static void readFile(String path) throws NonExistedFileException{
        File file = new File(path);
        if (!file.exists()) throw new NonExistedFileException();
    }
}

/**
 Создайте класс исключения, который будет выбрасываться при делении на 0.
 Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException(){
        super("Делить на 0 нельзя!");
    }
}

/**
 * Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
 * Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
class NonExistedFileException extends FileNotFoundException {
    public NonExistedFileException(){
        super("Файл не найден!");
    }
}