package lesson5.homework;

import java.util.concurrent.CountDownLatch;

public class Tunnel extends Stage {
    private int carCount = 0;
    private int limit;
    private CountDownLatch cdl;
    public Tunnel(int limit) {
        this.length = 80;
        this.limit = limit;
        this.description = "Тоннель " + length + " метров";
        cdl = new CountDownLatch(limit);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                carCount++;
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                if (carCount > limit) {
                    cdl.await();
                }

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);



            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

