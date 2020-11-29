package lesson5.homework;

public class ArrayCalc implements Runnable{
    private float[] arr;
    Thread t;

    public ArrayCalc(float[] arr) {
        this.arr = arr;
        t = new Thread(this, "Array calc");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
