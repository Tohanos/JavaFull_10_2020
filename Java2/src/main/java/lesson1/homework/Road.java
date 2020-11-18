package lesson1.homework;

public class Road {
    private int distance;

    public Road(int distance) {
        this.distance = distance;
    }

    public boolean attempt(Runnable runner) {
        return  (runner.run() >= distance);
    }

    public int getDistance() {
        return distance;
    }
}
