package lesson7.homework;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        int hunger = p.decreaseFood(appetite);
        if (!satiety) satiety = hunger == 0;
    }

    @Override
    public String toString() {
        return "Кот{" +
                "Имя='" + name + '\'' +
                ", наелся=" + (satiety ? "да" : "нет") +
                '}';
    }
}
