package Lesson13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordProcessor {
    private final String[] words;
    private final Map<String, Integer> wordCount = new HashMap<>();
    private final Set<String> uniqueWords = new TreeSet<>();

    // Конструктор принимает массив слов
    public WordProcessor(String[] words) {
        this.words = words;
        processWords(); // Выполняем обработку при создании объекта
    }

    // Метод для обработки слов (подсчёт и выделение уникальных слов)
    private void processWords() {
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        uniqueWords.addAll(wordCount.keySet());
    }

    // Метод для получения уникальных слов
    public Set<String> getUniqueWords() {
        return uniqueWords;
    }

    // Метод для получения подсчёта слов
    public Map<String, Integer> getWordCount() {
        return wordCount;
    }
}
