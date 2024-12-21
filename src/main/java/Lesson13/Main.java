package Lesson13;

import java.util.*;

public class Main {
    public static void main(String[] args) {

       //Задание 1
        // Массив слов
        String[] words = {
                "apple", "banana", "apple", "orange", "banana",
                "grape", "apple", "orange", "pear", "banana", "grape"
        };

        // Создаём объект WordProcessor
        WordProcessor processor = new WordProcessor(words);

        // Выводим уникальные слова
        System.out.println("Уникальные слова:");
        for (String word : processor.getUniqueWords()) {
            System.out.println(word);
        }

        // Выводим количество повторений каждого слова
        System.out.println("\nКоличество повторений слов:");
        for (Map.Entry<String, Integer> entry : processor.getWordCount().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        //Задание 2

            PhoneBook phoneBook = new PhoneBook();
            // Добавление номеров
            phoneBook.add("Ivanov", "123-456");
            phoneBook.add("Petrov", "234-567");
            phoneBook.add("Ivanov", "345-678");
            phoneBook.add("Sidorov", "456-789");
            phoneBook.add("Ivanov", "789-012");

            // Получение номеров
            System.out.println("Номера Иванова: " + phoneBook.get("Ivanov"));
            System.out.println("Номера Петрова: " + phoneBook.get("Petrov"));
            System.out.println("Номера Сидорова: " + phoneBook.get("Sidorov"));
            System.out.println("Номера неизвестного: " + phoneBook.get("Unknown"));
    }
}

