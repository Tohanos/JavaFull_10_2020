package lesson1.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskTwo {
    public static <T> ArrayList<T> arrayTransform(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        ArrayList<Integer> arrList = arrayTransform(arr);
        System.out.println(arrList);
    }
}
