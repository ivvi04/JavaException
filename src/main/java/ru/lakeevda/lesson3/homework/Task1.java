package ru.lakeevda.lesson3.homework;

import ru.lakeevda.lesson3.homework.people.People;
import ru.lakeevda.lesson3.homework.people.exceptions.BirthdayException;
import ru.lakeevda.lesson3.homework.people.exceptions.GenderException;
import ru.lakeevda.lesson3.homework.people.exceptions.PhoneException;
import ru.lakeevda.lesson3.homework.people.exceptions.StringException;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People people = new People();
        while (true) {
            System.out.println("Введите данные через пробел (exit - выход):");
            System.out.println("Формат ввода: ФИО_полностью дата_рождения(формат: dd.mm.yyyy) номер_телефона пол(f/m)");
            String nextLine = scanner.nextLine();
            if (nextLine.equals("exit")) break;
            try {
                people.setData(nextLine);
                File file = new File(people.getLastName() + ".txt");
                if (checkFileNotExistPeople(file, people)) {
                    try (FileWriter fileWriter = new FileWriter(file, true)) {
                        fileWriter.write(people.toString() + "\n");
                    }
                }
                System.out.println("Данные успешно записаны");
            } catch (PhoneException | GenderException | StringException | BirthdayException | RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkFileNotExistPeople(File file, People people) throws IOException {
        boolean result = true;
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals(people.toString())) {
                        throw new RuntimeException(
                                String.format("Введенные данные уже присутствуют в файле [%s]",
                                        file.getName()));
                    }
                }
            }
        }
        return result;
    }
}
