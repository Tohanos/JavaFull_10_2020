package lesson6.homework;

import java.util.Arrays;

public class ArrayProcessOne {
    public static void main(String[] args) {

        int[] inArray1 = {3, 2, 1, 0, 4, 6, 3, 3};
        int[] inArray2 = {1, 1, 1, 4, 1, 1, 4, 1};

        System.out.println(Arrays.toString(arraySearchFor4(inArray1)));
        System.out.println(arraySearchForOneFour(inArray2));
    }

    public static int[] arraySearchFor4(int[] array) {
        int[] result;
        int i;
        int j = -1;
        for (i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                j = i;
            }
        }
        if (j == -1) {
            throw new RuntimeException("Cannot find 4 in array");
        }

        result = new int[array.length - j - 1];
        for (i = 0; j < result.length; i++) {
            i++;
            result[j] = array[i + j];
        }
        return result;
    }

    public static boolean arraySearchForOneFour(int[] array) {

        int count1 = 0;
        int count4 = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count1++;
            } else if (array[i] == 4) {
                count4++;
            } else
                return false;
        }
        if (count1 == 0 || count4 == 0) {
            return false;
        }
        return true;
    }
}
