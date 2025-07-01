package ru.st;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordFrequencies = new HashMap<>();

    public void processLine(String line) {
        String[] words = line.split(" ");

        for (String wordRaw : words) {
            String word = cleanWord(wordRaw);

            if (!word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
    }

    private String cleanWord(String word) {
        return word.toLowerCase().replaceAll("[^a-zа-я0-9]", "");
    }

    public Map<String, Integer> getWordFrequencies() {
        return wordFrequencies;
    }
}
