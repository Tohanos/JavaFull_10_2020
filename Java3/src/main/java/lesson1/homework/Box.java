package lesson1.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    private ArrayList<T> container;
    private double weight;

    public Box () {
        container = new ArrayList<>();
        weight = 0.0f;
    }

    public Box (T... fruits) {
        container = new ArrayList<>(Arrays.asList(fruits));
        for (T items:
             fruits) {
            weight += items.getWeight();
        }
    }

    public void addItem (T fruit) throws RuntimeException {
        if(!container.isEmpty()) {
            if (!fruit.getClass().getName().equals(container.get(0).getClass().getName())) {
                System.out.println("Cannot put different types of fruits in one box!");
                throw new RuntimeException();
            }
        }
        container.add(fruit);
        weight += fruit.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    public boolean compare (Box<?> box) {
        return (Math.abs(weight - box.getWeight()) < 0.000001 );
    }

    public void unloadTo(Box<T> box) {
        for (T fruit:
             container) {
            try {
                box.addItem(fruit);
            } catch (RuntimeException exception) {
                System.out.println("Box cannot contain different types of fruits!");
                return;
            }
        }
        container.clear();
        weight = 0.0f;
    }
}
