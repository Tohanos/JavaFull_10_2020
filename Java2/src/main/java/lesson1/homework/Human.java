package lesson1.homework;

public class Human implements Runnable, Jumpable{
    private String name;
    private final int jumpHeight = 2;
    private final int runDistance = 200;

    public Human(String name) {
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
