# Исключения в программировании и их обработка (семинары)

## Урок 1. Обработка ошибок в программировании

**[Задание 1](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson1/homework/Task1.java)**

Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

- Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
- Метод divisionByZero - Деление на 0
- Метод numberFormatException - Ошибка преобразования строки в число

Важно: они не должны принимать никаких аргументов

**[Задание 2](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson1/homework/Task2.java)**

Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив c, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.

Если длины массивов не равны - верните нулевой массив длины 1.

Напишите свой код в методе subArrays класса Answer. Метод subArrays принимает на вход два параметра:

- int[] a - первый массив
- int[] b - второй массив

**[Задание 3](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson1/homework/Task3.java)**

Реализуйте метод divArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив с, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.

Если длины массивов не равны - верните нулевой массив длины 1.

Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

Напишите свой код в методе divArrays класса Answer. Метод divArrays принимает на вход два параметра:

- int[] a - первый массив
- int[] b - второй массив

## Урок 2. Исключения и их обработка

**[Задание 1](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson2/homework/Task1.java)**

Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

**[Задание 2](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson2/homework/Task2.java)**

Если необходимо, исправьте данный код ([задание 2](https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit))

**[Задание 3](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson2/homework/Task3.java)**

Дан следующий код, исправьте его там, где требуется ([задание 3](https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit))


**[Задание 4](https://github.com/ivvi04/JavaException/blob/master/src/main/java/ru/lakeevda/lesson2/homework/Task4.java)**

Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.