package ru.lakeevda.lesson2.seminar;

import java.io.*;

/**
 * ��������� ����������� ��������� ���
 */
public class Task4 {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String str = strings[1];
            test();
            int a = 1 / 0;

            inputStream = new FileInputStream("sdafgdsaf");
        } catch (StackOverflowError error) {
            System.err.println("stack overflow error");
//            throw new RuntimeException();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("� ��� ����� ����������!");
        }
        System.out.println("� ���!");
    }


    private static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        test();
    }
}