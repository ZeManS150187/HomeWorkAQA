package Lesson12;

// Пользовательское исключение для проверки размера массива
public class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
