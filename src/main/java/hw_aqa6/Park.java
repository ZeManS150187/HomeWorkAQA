package hw_aqa6;
//Задание 3
/*Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
  времени их работы и стоимости.*/
public class Park {
    public static class Attraction{
        //поля внутреннего класса
        private String name;
        private String workingHours;
        private double cost;

        //конструктор внутреннего класса
        public Attraction(String name, String workingHours, double cost){
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        //Метод для вывода в консоль информации об аттракционах
        public void displayAttractionInfo() {
            System.out.println("Attraction Name: " + name);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Cost: " + cost);
        }
    }
}
