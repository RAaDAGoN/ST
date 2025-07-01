package ru.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    /*
    Интерфейс для обработки строк по одной
    void readLines - читает файл построчно и для каждой строки вызывает переданный обработчик
     */
    @FunctionalInterface
    public interface LineProcessor {
        void processLine(String line);
    }

    public void readLines(String resourceName, LineProcessor processor) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);

        if (inputStream == null) {
            System.out.println("Файл не найден в ресурсах: " + resourceName);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                processor.processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения ресурса: " + e.getMessage());
        }
    }
}


