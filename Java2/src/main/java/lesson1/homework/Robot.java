package lesson1.homework;

public class Robot implements Runnable, Jumpable{
    private String name;
    private final int jumpHeight = 10;
    private final int runDistance = 10;

    public Robot(String name) {
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
