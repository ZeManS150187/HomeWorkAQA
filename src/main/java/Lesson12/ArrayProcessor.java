package Lesson12;

public class ArrayProcessor {
    // Метод для обработки массива
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4!");
        }

        int sum = 0;

        // Проходим по массиву и пытаемся преобразовать в int
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Ошибка в данных массива: ячейка [%d][%d] содержит неверное значение '%s'", i, j, array[i][j])
                    );
                }
            }
        }
        return sum;
    }
}