package lesson1.homework;

public class Apple extends Fruit{
    private double weight;

    public Apple() {
        weight = 1.0f;
    }

    public Apple(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
