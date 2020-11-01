package lesson6.homework;

public class Run extends Activity{
    private double range;
    public Run(double range) {
        super("бежит");
        this.range = range;
    }

    String movement (Animal creature) {
        String result = creature.getName() + " " +
                this.getType() + " ";
        if (creature.getRunRange() >= range) {
            return result + "и пробежал(а), при этом сказав " + super.movement(creature);
        }
        return result + ", но не пробежал(а), сказав " + super.movement(creature);
    }
}
