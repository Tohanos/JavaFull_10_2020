package lesson5.homework;

public class ThreadArrayTest {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;




    public static float[] methodSingleThread () {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Single thread float calculations: " + (System.currentTimeMillis() - a));
        return arr;
    }

    public static float[] methodMultiThread () {
        float[] arr = new float[SIZE];
        float[] halfArr1 = new float[HALF];
        float[] halfArr2 = new float[HALF];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, halfArr1, 0, HALF);
        System.arraycopy(arr, HALF, halfArr2, 0, HALF);
        ArrayCalc ar1 = new ArrayCalc(halfArr1);
        ArrayCalc ar2 = new ArrayCalc(halfArr2);
        while (ar1.t.isAlive() || ar2.t.isAlive()) { }

        System.arraycopy(halfArr1, 0, arr, 0, HALF);
        System.arraycopy(halfArr2, 0, arr, HALF, HALF);

        System.out.println("Multi thread float calculations: " + (System.currentTimeMillis() - a));
        return arr;
    }


    public static void main(String[] args) {
        float arr[];
        arr = methodSingleThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }

        arr = methodMultiThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }

}
