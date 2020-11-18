package lesson1.homework;

public class Contest {


    public static void main(String[] args) {
        Cat cat = new Cat("Мурка");
        Human human = new Human("Василий Иванович");
        Robot robot = new Robot("R2D2");
        Wall[] walls = new Wall[5];
        Road[] roads = new Road[5];
        for (int i = 0; i < 5; i++) {
            walls[i] = new Wall(i);
            roads[i] = new Road(i * 40);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("По дороге длиной " + roads[i].getDistance() + " бегут:");
            System.out.println(cat.getName() +
                    (roads[i].attempt(cat) ? " пробежала" : " не пробежала"));
            System.out.println(human.getName() +
                    (roads[i].attempt(human) ? " пробежал" : " не пробежал"));
            System.out.println(robot.getName() +
                    (roads[i].attempt(robot) ? " пробежал" : " не пробежал"));
            System.out.println("Через стену высотой " + walls[i].getHeight() + " прыгают:");
            System.out.println(cat.getName() +
                    (walls[i].attempt(cat) ? " перепрыгнула" : " не перепрыгнула"));
            System.out.println(human.getName() +
                    (walls[i].attempt(human) ? " перепрыгнул" : " не перепрыгнул"));
            System.out.println(robot.getName() +
                    (walls[i].attempt(robot) ? " перепрыгнул" : " не перепрыгнул"));

        }

    }
}
