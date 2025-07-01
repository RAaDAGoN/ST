package ru.st;

import java.util.Map;

public class WordFrequencyPrinter {
    public void print(Map<String, Integer> wordFrequencies) {
        System.out.println("Частота слов в файле:");

        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

