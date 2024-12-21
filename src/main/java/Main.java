import java.util.*;
import Lesson10.*;
import Lesson12.*;

import static Lesson12.ArrayProcessor.processArray;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        // Создаем массив котов
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        // Создаем миску с едой
        FoodBowl bowl = new FoodBowl(50);

        // Кормим котов по очереди и считаем, кто поел, а кто остался голодным
        int fedCats = 0;
        int hungryCats = 0;

        for (Cat cat : cats) {
            if (cat.eatFromBowl(bowl)) {
                fedCats++;
            } else {
                hungryCats++;
            }
        }

        // Выводим результат
        System.out.println("Количество котов, которые поели: " + fedCats);
        System.out.println("Количество голодных котов: " + hungryCats);

        // Добавляем еду и снова кормим оставшихся голодных котов
        bowl.addFood(30);

        for (Cat cat : cats) {
            if (!cat.isFull() && cat.eatFromBowl(bowl)) {
                fedCats++;
                hungryCats--;
            }
        }

        // Финальный результат
        System.out.println("После добавления еды:");
        System.out.println("Количество котов, которые поели: " + fedCats);
        System.out.println("Количество голодных котов: " + hungryCats);
        System.out.println("В миске осталось " + bowl.getFood() + " еды.");

        //Задание 2
        // Создаем фигуры
        Shape circle = new Circle(5); // Круг с радиусом 5
        Shape rectangle = new Rectangle(4, 7); // Прямоугольник 4x7
        Shape triangle = new Triangle(3, 4, 5); // Треугольник со сторонами 3, 4, 5

        // Задаем цвета для каждой фигуры и выводим характеристики
        System.out.println("Круг:");
        circle.printCharacteristics("Красный", "Черный");

        System.out.println("\nПрямоугольник:");
        rectangle.printCharacteristics("Синий", "Зеленый");

        System.out.println("\nТреугольник:");
        triangle.printCharacteristics("Желтый", "Фиолетовый");


        //Практическое задание 12
        ArrayProcessor arrayProcessor = new ArrayProcessor();


        // Пример массива
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "XX", "12"},
                {"13", "14", "15", "16"}
        };

        // Обрабатываем массивы
        try {
            System.out.println("Сумма элементов validArray: " + processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов invalidSizeArray: " + processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов invalidDataArray: " + processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}

