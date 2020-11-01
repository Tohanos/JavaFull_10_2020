package lesson6.homework;

public class Swim extends Activity{
    private double range;
    public Swim(double range) {
        super("плывёт");
        this.range = range;
    }

    String movement (Animal creature) {
        String result = creature.getName() + " " +
                this.getType() + " ";

        if (creature.getSwimRange() >= range) {
            return result + "и проплыл(а), при этом сказав " + super.movement(creature);
        }
        return result + ", но не проплыл(а), тут и говорить нечего";
    }
}
