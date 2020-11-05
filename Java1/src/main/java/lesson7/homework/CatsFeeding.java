package lesson7.homework;

public class CatsFeeding {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Барсик",10);
        cats[1] = new Cat("Персик",5);
        cats[2] = new Cat("Бонифаций",15);
        cats[3] = new Cat("Дымок",8);
        cats[4] = new Cat("Гав",20);

        Plate plate = new Plate(40);
        int i = 0;
        while(plate.info() > 0) {
            cats[i].eat(plate);
            i++;
            if (i > 4) i = 0;
        }
        for (int j = 0; j < 5; j++) {
            System.out.println(cats[j]);
        }
    }
}
