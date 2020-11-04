package lesson7.homework;

public class Plate {
    private int food;

    public Plate (int food) {
        this.food = food;
    }

    public int decreaseFood(int n) {
        if (food > n) {
            food -= n;
            return 0;
        }
        int cantEat = n - food;
        food = 0;
        return cantEat;
    }

    public void increaseFood(int n) {
        if (n > 0) {
            food += n;
        } else {
            System.out.println("Не надо воровать еду у котиков");
        }
    }

    public int info() {
        System.out.println("plate: " + food);
        return food;
    }
}
