package ru.lakeevda.lesson2.seminar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 *
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 *
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=6", "Полина=?", "Владимир=?", "Константин=?", "Иван=4");
    //для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        String path = "task3.txt";
        writeToFile(strings, path);
        System.out.println(readFromList(path));
        rewriteFile(path);

    }

    /**
     * Запись в файл
     */
    public static void writeToFile (List<String> stringList, String path) {
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            for (String elem : stringList) {
                fileWriter.write(elem + "\n");
            }
            fileWriter.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Чтение в лист
     */
    public static Map<String, Integer> readFromList (String path) {
        File file = new File(path);
        Map<String, Integer> result = new LinkedHashMap<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("=");
                String name = arr[0];
                String temp = arr[1];
                int number;
                if (temp.equals("?")) number = name.length();
                else number = Integer.parseInt(temp);

                result.put(name, number);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.out.println("Недопустимое значение");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


    /**
     * Изменение листа
     */
    public static void rewriteFile (String path) {
        Map<String, Integer> stringIntegerMap = readFromList(path);

        List<String> stringList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            stringList.add(entry.toString());
        }
        writeToFile(stringList, path);
    }
}
