package lesson1.homework;

public class Wall{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean attempt(Jumpable jumper) {
        return  (jumper.jump() >= height);
    }

    public int getHeight() {
        return height;
    }
}
