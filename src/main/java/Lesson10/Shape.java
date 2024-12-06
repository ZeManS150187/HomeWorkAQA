package Lesson10;

public interface Shape {
    double calculatePerimeter();

    double calculateArea();

    // Дефолтный метод для вывода характеристик фигуры
     default void printCharacteristics(String fillColor, String borderColor) {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
