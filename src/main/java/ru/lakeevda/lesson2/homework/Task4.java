package ru.lakeevda.lesson2.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("������� ������: ");
                try {
                    String s = getString(bufferedReader);
                    System.out.printf("��������� ������ �����: '%s'", s);
                    break;
                } catch (StringEmptyException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getString(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) throw new NullPointerException("��������� �� ����� ��������� �� null!");
        String s = bufferedReader.readLine();
        if (s.equals("")) throw new StringEmptyException("������ ������ ������� ������!");
        return s;
    }
}

class StringEmptyException extends RuntimeException {
    public StringEmptyException(String message) {
        super(message);
    }
}
