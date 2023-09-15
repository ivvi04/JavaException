package ru.lakeevda.lesson3.seminar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Перепишите код, воспользовавшись механизмом try-with-resources
 */
public class Task1 {
    public static void main(String[] args) {
        try {
            rwLine(Path.of("Task1Read.txt"), Path.of("Task2Read.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }
}