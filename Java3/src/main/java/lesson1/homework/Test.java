package lesson1.homework;

public class Test {
    public static void main(String[] args) {

        Box<Apple> b1 = new Box<>(new Apple());
        Box<Orange> b2 = new Box<>(new Orange());

        for (int i = 0; i < 10; i++) {
            b1.addItem(new Apple());
        }

        for (int i = 0; i < 8; i++) {
            b2.addItem(new Orange());
        }

        System.out.println(b1.getWeight());
        System.out.println(b2.getWeight());

        Box b3 = new Box<>();
        b1.unloadTo(b3);
        System.out.println(b3.getWeight());

        b3.unloadTo(b2);




    }
}
