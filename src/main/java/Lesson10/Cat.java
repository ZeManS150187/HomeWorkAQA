package Lesson10;


public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;

    public Cat() {
        super();
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public boolean eatFromBowl(FoodBowl bowl) {
        if (!isFull && bowl.getFood() >= 15) {
            bowl.decreaseFood(15);
            isFull = true;
            System.out.println("Кот поел и сыт.");
            return true;
        } else if (isFull) {
            System.out.println("Кот уже сыт.");
        } else {
            System.out.println("В миске недостаточно еды для кота.");
        }
        return false;
    }

    public boolean isFull() {
        return isFull;
    }
}