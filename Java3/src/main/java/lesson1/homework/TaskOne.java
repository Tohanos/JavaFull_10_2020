package lesson1.homework;

public class TaskOne {
    public static <T> void changeArrayElems(T[] arr, int index1, int index2) {
        T element = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = element;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        changeArrayElems(arr, 4, 6);
        for (Integer iVal:
             arr) {
            System.out.println(iVal);
        }
    }
}
