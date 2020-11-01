package lesson6.homework;

public class Animal {
    private final String name;
    private final String animalType;
    private final double runRange;
    private final double swimRange;
    private final String voice;

    public Animal(String name, String animalType,double runRange, double swimRange, String voice) {
        this.name = name;
        this.animalType = animalType;
        this.runRange = runRange;
        this.swimRange = swimRange;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    public double getRunRange() {
        return runRange;
    }

    public double getSwimRange() {
        return swimRange;
    }

    public String getVoice() {
        return voice;
    }

    public String getAnimalType() {
        return animalType;
    }
}
