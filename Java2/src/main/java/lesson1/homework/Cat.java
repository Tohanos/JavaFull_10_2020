package lesson1.homework;

public class Cat implements Jumpable, Runnable{
    private String name;
    private final int jumpHeight = 4;
    private final int runDistance = 100;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int jump() {
        return jumpHeight;
    }

    @Override
    public int run() {
        return runDistance;
    }
}
