package Lesson10;

public class FoodBowl {
    private int food;

    public FoodBowl(int initialFood) {
        this.food = Math.max(initialFood, 0); // Еда в миске не может быть отрицательной
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в миску. Сейчас в миске " + food + " еды.");
        }
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            food = 0; // Еды не может стать меньше 0
        }
    }
}
