import java.util.*;
import Lesson10.*;

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
    }
}