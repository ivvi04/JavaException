package ru.lakeevda.lesson2.homework;

public class Task3 {
    public static void main(String[] args) {
        try {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("������� �� ����!");
            }

            try {
                printSum(23, 234);
            } catch (NullPointerException ex) {
                System.out.println("��������� �� ����� ��������� �� null!");
            }

            try {
                int[] abc = {1, 2};
                abc[3] = 9;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("������ ������� �� ������� ������ �������!");
            }
        } catch (Throwable ex) {
            System.out.println("���-�� ����� �� ���...");
        }
    }

    public static void printSum (Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }
}
