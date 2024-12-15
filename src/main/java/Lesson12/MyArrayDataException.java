package Lesson12;

// Пользовательское исключение для неверных данных
public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
