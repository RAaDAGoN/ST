package ru.st;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();

    public void processLines(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            processLine(lines.get(i));
        }
    }

    private void processLine(String line) {
        String[] words = line.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = cleanWord(words[i]);

            if (!word.isEmpty()) {
                if (wordFrequencies.containsKey(word)) {
                    wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                } else {
                    wordFrequencies.put(word, 1);
                }
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

