package ru.st;

import org.testng.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class WordCounterTest {
    @Test
    public void testSimpleJavaWordCount() {
        WordCounter counter = new WordCounter();

        // Исходные строки
        counter.processLines(Arrays.asList("Java is great.", "I love Java!", "JAVA."));

        Map<String, Integer> result = counter.getWordFrequencies();

        // Проверяем, что слово java встретилось 3 раза
        Assert.assertEquals((int) result.get("java"), 3);
    }




}