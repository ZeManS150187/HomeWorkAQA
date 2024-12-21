package Lesson13;

import java.util.*;

public class PhoneBook {
    // Хранилище телефонных номеров
    private Map<String, List<String>> phoneBook = new HashMap<>();

    // Метод для добавления номера
    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для получения списка номеров по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }


}
