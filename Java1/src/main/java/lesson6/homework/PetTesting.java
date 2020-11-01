package lesson6.homework;

public class PetTesting {
    public static void move(Activity act, Animal pet) {
        System.out.println(act.movement(pet));
    }

    public static void main(String[] args) {
        Cat catMurk = new Cat("Мурка", 200, 0);
        Dog dogChap = new Dog("Полкан", 100, 100);
        move(new Run(100), catMurk);
        move(new Swim(10), catMurk);
        move(new Run(100), dogChap);
        move(new Swim(10), dogChap);

    }
}
