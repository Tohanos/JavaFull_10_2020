package lesson1.homework;

public class Orange extends Fruit{
    private double weight;

    public Orange() {
        weight = 1.5f;
    }

    public Orange(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
