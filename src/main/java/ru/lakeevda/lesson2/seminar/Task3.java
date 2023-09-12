package ru.lakeevda.lesson2.seminar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * �������� � ���� ��������� ������:
 *
 * ����=4
 * �����=5
 * ������=6
 * ��������=?
 * ������=?
 * ����������=?
 * ����=4
 *
 * ���������� �����, ������� ��������� ������ �� ����� � ��������� � ��������� ������ (���� HashMap,
 * ���� �������� � ��� �������). � ��������� ������ ����� ����� ������ �� ��������� ������,
 * ���� ��������� �������� ?, �������� ��� �� ��������������� �����.���� �� �����-�� �����
 * ����������� ������, �������� �� ����� ��� ?, ������� ���������� ����������.
 * �������� � ��� �� ���� ������ � ����������� ��������� ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("����=4", "�����=5", "������=6", "������=?", "��������=?", "����������=?", "����=4");
    //��� ��������, �������� �����-�� �� �������� �� null

    public static void main(String[] args) {
        String path = "task3.txt";
        writeToFile(strings, path);
        System.out.println(readFromList(path));
        rewriteFile(path);

    }

    /**
     * ������ � ����
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
     * ������ � ����
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
            System.out.println("������������ ��������");
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
     * ��������� �����
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
