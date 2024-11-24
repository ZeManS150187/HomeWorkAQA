package hw_aqa2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1.");
        printThreeWords("Orange");
        printThreeWords("Banana");
        printThreeWords("Apple");
        System.out.println();

        System.out.println("Задание 2.");
        System.out.println(checkSumSign());
        System.out.println();

        System.out.println("Задание 3.");
        System.out.println(printColor());
        System.out.println();

        System.out.println("Задание 4.");
        System.out.println(compareNumber());
        System.out.println();

        System.out.println("Задание 5.");
        System.out.println(comparison(100, 2));
        System.out.println();

        System.out.println("Задание 6.");
        System.out.println(checkSign(-10));
        System.out.println();

        System.out.println("Задание 7.");
        System.out.println(checkSig(0));
        System.out.println();

        System.out.println("Задание 8.");
        stringMethod("Java ", 3);
        System.out.println();
        System.out.println();

        System.out.println("Задание 9.");
        System.out.println(isLeapYear(96));
        System.out.println();

        System.out.println("Задание 10.");
        System.out.println(isArray(new int[]{1, 0, 1, 1, 1, 0}));
        System.out.println();

        System.out.println("Задание 11.");
        isArr(new int[100]);
        System.out.println();

        System.out.println("Задание 12.");
        isArrs(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        System.out.println();

        System.out.println("Задание 13.");
        isArrays(new int[5][5]);
        System.out.println();

        System.out.println("Задание 14.");
        System.out.println(Arrays.toString(isMassiv(5, 10)));
        System.out.println();


    }

    // Задание 1.
    /*Создай метод printThreeWords(), который при вызове должен отпечатоть в столбец три слова
     Orange, Banana, Apple */
    public static void printThreeWords(String fruit) {
        System.out.println(fruit);
    }

    //Задание 2.
    /* Создайте метод checkSumSign(), в теле которого объявите
       две int переменные а и b, и инициализируйте их любыми
       значениями, которыми захотите. Далее метод должен
       просуммировать эти переменные, и если их сумма больше
       или равна 0, то вывести в консоль сообщение "Сумма
       положительная", в противном случае - "Сумма
       отрицательная" */
    public static String checkSumSign() {
        int a = 3;
        int b = -5;
        return (a + b) >= 0 ? "Сумма положительная" : "Сумма отрицательная";
    }

    //Задание 3.
    /* Создайте метод printColor() в теле которого задайте int
       переменную value и инициализируйте ее любым значением.
       Если value меньше 0 (0 включительно), то в консоль метод
       должен вывести сообщение "Красный", если лежит в пределах
       от 0 (0 исключительно) до 100 (100 включительно), то
       "Желтый", если больше 100 (100 исключительно) - "Зеленый"*/
    public static String printColor() {
        int value = 111;
        return value <= 0 ? "Красный" : (value > 0 && value <= 100) ? "Жёлтый" : "Зелёный";
    }

    //Задание 4.
    /*Создайте метод compareNumbers(), в теле которого
      объявите две int переменные а и b, и инициализируйте их
      любыми значениями, которыми захотите. Если а больше или
      равно b, то необходимо вывести в консоль сообщение "a >=b",
      в противном случае "а < b"*/
    public static String compareNumber() {
        int a = 5;
        int b = 5;
        return a >= b ? "a >= b" : "a < b";
    }

    //Задание 5.
    /*Напишите метод, принимающий на вход два целых числа и
      проверяющий, что их сумма лежит в пределах от 10 до 20
      (включительно), если да - вернуть true, в противном случае - false*/
    public static boolean comparison(int a, int b) {
        return ((a + b) > 10 && (a + b) <= 20) ? true : false;
    }

    //Задание 6.
    /*Напишите метод, которому в качестве параметра передается
      целое число, метод должен напечатать в консоль, положительное
      ли число передали или отрицательное. Замечание: ноль считаем
      положительным числом.*/
    public static String checkSign(int number) {
        return number >= 0 ? "Число положительное" : "Число отрицательное";
    }

    //Задание 7.
    /*Напишите метод, которому в качестве параметра передается
      целое число. Метод должен вернуть true, если число
      отрицательное, и вернуть false если положительное.
      Замечание: ноль считаем положительным числом*/
    public static boolean checkSig(int number) {
        return number >= 0 ? false : true;
    }

    //Задание 8.
    /*Напишите метод, которому в качестве аргументов
      передается строка и число, метод должен отпечатать в
      консоль указанную строку, указанное количество раз*/
    public static void stringMethod(String text, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(text);
        }
    }

    //Задание 9.
    /*Напишите метод, который определяет, является ли год
      високосным, и возвращает boolean (високосный - true, не
      високосный - false). Каждый 4-й год является високосным,
      кроме каждого 100-го, при этом каждый 400-й - високосный.*/
    //полез гуглить) а это оказывается рабочая схема
    public static boolean isLeapYear(int year) {
        // Если год кратен 400, то это високосный год
        if (year % 400 == 0) {
            return true;
        }
        // Если год кратен 100, но не кратен 400, то это не високосный год
        if (year % 100 == 0) {
            return false;
        }
        // Если год кратен 4, то это високосный год
        if (year % 4 == 0) {
            return true;
        }
        // Во всех остальных случаях год не високосный
        return false;
    }

    //Задание 10.
    /*Задать целочисленный массив, состоящий из элементов 0
      и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
      условия заменить 0 на 1, 1 на 0;*/
    public static String isArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        return Arrays.toString(a);
    }

    //Задание 11.
    /*Задать пустой целочисленный массив длиной 100. С
      помощью цикла заполнить его значениями 12 3 4 5 6 7 8 ... 100*/
    public static void isArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        System.out.println(Arrays.toString(a));
    }

    //Задание 12.
    /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по
      нему циклом, и числа меньшие 6 умножить на 2*/
    public static void isArrs(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //Задание 13.
    /*Создать квадратный двумерный целочисленный массив
      (количество строк и столбцов одинаковое), и с помощью
      цикла(-ов) заполнить его диагональные элементы единицами
      (можно только одну из диагоналей, если обе сложно).
      Определить элементы одной из диагоналей можно по
      следующему принципу: индексы таких элементов равны, то
      есть [0][0], [1][1], [2][2], .... [n][n]*/
    public static void isArrays(int[][] a) {
        // Заполняем массив по диагоналям
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if ((i == j) || (i + j == a.length - 1)) {
                    a[i][j] = 1;
                }
            }
        }
        //Выводим массив в консоль
        for (int j = 0; j < a.length; j++) {
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[j][k] + " ");
            }
            System.out.println();
        }
    }

    //Задание 14.
    /*Написать метод, принимающий на вход два аргумента: len и
      initialValue, и возвращающий одномерный массив типа int длиной
      len, каждая ячейка которого равна initialValue*/
    public static int[] isMassiv(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = initialValue;
        }
        return a;
    }
}


