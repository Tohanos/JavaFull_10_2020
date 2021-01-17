package lesson4.homework;

public class ThreeThreads {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new DummyThread(1, "A"));
        Thread thread2 = new Thread(new DummyThread(2, "B"));
        Thread thread3 = new Thread(new DummyThread(3, "C"));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
