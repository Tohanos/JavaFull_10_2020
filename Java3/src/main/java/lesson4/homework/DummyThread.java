package lesson4.homework;

import java.util.concurrent.TimeUnit;

public class DummyThread implements Runnable{

    private static volatile int currentNumber = 0;
    private int number;
    private boolean running;
    private int counter = 0;

    private String s;

    public DummyThread(int number, String s) {
        this.number = number;
        this.s = s;
    }


    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                if (currentNumber == (number - 1)) {
                    System.out.print(s);
                    counter++;
                    currentNumber = (currentNumber + 1) % 3;
                    TimeUnit.MILLISECONDS.sleep(300);
                    if (counter == 5) {
                        running = false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
