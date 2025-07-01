package ru.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {

    public List<String> readLines(String resourceName) {
        List<String> lines = new ArrayList<String>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);

        if (inputStream == null) {
            System.out.println("Файл не найден в ресурсах: " + resourceName);
            return lines;
        }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения ресурса: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignore) {
                }
            }
        }

        return lines;
    }
}


