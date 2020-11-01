package lesson6.homework;

public class Activity {
    private String type;

    public Activity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    String movement(Animal creature) {
        return creature.getVoice();
    }
}
