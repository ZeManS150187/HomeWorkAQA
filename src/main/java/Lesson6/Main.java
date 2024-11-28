package Lesson6;


import hw_aqa6.Employee;
import hw_aqa6.Park;

public class Main {
    public static void main(String[] args) {
        //Задание 2
        /*Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
          Конструктор класса должен заполнять эти поля при создании объекта.
          Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/

        hw_aqa6.Employee[] employees = new hw_aqa6.Employee[5];


        employees[0] = new hw_aqa6.Employee("Ivanov Ivan", "Business Analyst", "ivanov@mail.com", "1234567890", 60000, 30);
        employees[1] = new hw_aqa6.Employee("Petrova Anna", "Java developer", "anna@mail.com", "2345678901", 80000, 28);
        employees[2] = new hw_aqa6.Employee("Sidorov Alexey", "QA", "alexey@mail.com", "3456789012", 50000, 35);
        employees[3] = new hw_aqa6.Employee("Smirnov Sergey", "HR Specialist", "sergey@mail.com", "4567890123", 45000, 40);
        employees[4] = new hw_aqa6.Employee("Kuznetsova Olga", "AQA", "olga@mail.com", "5678901234", 58000, 32);

        // Выводим в консоль информацию о сотрудниках
        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }

        //Задание 3.
        //Так, для проверки

        hw_aqa6.Park.Attraction attraction = new hw_aqa6.Park.Attraction("Вальс", "С 9.00 - 18.00", 5);
        hw_aqa6.Park.Attraction attraction1 = new hw_aqa6.Park.Attraction("Ромашка", "С 9.00 - 18.00", 4);
        hw_aqa6.Park.Attraction attraction2 = new Park.Attraction("Сюрприз", "С 9.00 - 18.00", 6);

        attraction.displayAttractionInfo();
        System.out.println();

        attraction1.displayAttractionInfo();
        System.out.println();

        attraction2.displayAttractionInfo();
        System.out.println();


    }
}

