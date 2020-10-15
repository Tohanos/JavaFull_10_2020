package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //1
        int[] nElems = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(nElems);
        System.out.println(Arrays.toString(nElems));

        //2
        int[] kElems = new int[8];
        multipleByThreeArray(kElems);
        System.out.println(Arrays.toString(kElems));

        //3
        int[] lELems = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        checkArrayElemLessThenSix(lELems);
        System.out.println(Arrays.toString(lELems));

        //4
        int size = sizeInput("Введите размер квадратной матрицы");
        printSquareMatrix(size);

        //5
        size = sizeInput("Введите размер массива");
        int[] arrayToCheck = new int[size];
        arrayInput(arrayToCheck);
        int[] result = selectMinMaxFromArray(arrayToCheck);
        System.out.println("Минимальное значение = " + result[0] + " Максимальное значение =" + result[1]);

        //6

        size = sizeInput("Введите размер массива");
        arrayToCheck = new int[size];
        arrayInput(arrayToCheck);
        if (leftAndRightSumsEquals(arrayToCheck)) {
            System.out.println("Сумма левой и правой части равны");
        } else {
            System.out.println("Сумма левой и правой части НЕ равны");
        }


        //7
        int shift = sizeInput("Введите сдвиг для массива");
        arrayRotate(arrayToCheck, shift);
        System.out.println(Arrays.toString(arrayToCheck));


    }

    public static void invertArray(int[] arrayIn) {
        for (int i = 0; i < arrayIn.length; i++) {
            arrayIn[i] = 1 - arrayIn[i];
        }
    }

    public static void multipleByThreeArray(int[] arrayIn) {
        for (int i = 0; i < arrayIn.length; i++) {
            arrayIn[i] = i * 3;
        }
    }

    public static void checkArrayElemLessThenSix(int[] arrayIn) {
        for (int i = 0; i < arrayIn.length; i++) {
            if (arrayIn[i] < 6) arrayIn[i] *= 2;
        }
    }

    public static void printSquareMatrix(int size) {
        int[][] square = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i == (size - j - 1)) square[i][j] = 1;
                else square[i][j] = 0;
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] selectMinMaxFromArray(int[] arrayIn) {
        int elemMin = arrayIn[0], elemMax = arrayIn[0];
        for (int elem :
                arrayIn) {
            if (elemMin > elem) elemMin = elem;
            if (elemMax < elem) elemMax = elem;
        }
        int[] returnVal = new int[2];
        returnVal[0] = elemMin;
        returnVal[1] = elemMax;
        return returnVal;
    }

    public static int sizeInput(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        return sc.nextInt();
    }

    public static void arrayInput(int[] array) {
        Scanner sc = new Scanner(System.in);
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.println("Введите " + (i + 1) + "-й элемент массива");
            array[i] = sc.nextInt();
        }
    }

    public static boolean leftAndRightSumsEquals(int[] arrayToCheck) {
        boolean result = false;
        int size = arrayToCheck.length;
        int sum = 0, leftSum = 0;

        for (int elem : arrayToCheck) {
            sum += elem;
        }
        if (sum % 2 == 0) {
            for (int elem : arrayToCheck) {
                leftSum += elem;
                if (leftSum == sum / 2) {
                    result = true;
                    break;
                }
                if (leftSum > sum / 2) {
                    break;
                }
            }
        }
        return result;
    }

    public static void arrayRotate(int[] inArray, int n) {
        int size = inArray.length;
        int bucket;     //переменная для хранения изменяемого элемента массива
        int curCounter = 0;

        while (curCounter != n) {

            if (n < 0) {
                //сдвиг влево
                bucket = inArray[0];
                for (int i = 1; i < size; i++) inArray[i - 1] = inArray[i];
                inArray[size - 1] = bucket;
                curCounter--;
            } else {
                //сдвиг вправо
                bucket = inArray[size - 1];
                for (int i = size - 1; i > 0; i--) inArray[i] = inArray[i - 1];
                inArray[0] = bucket;
                curCounter++;
            }
        }
    }
}


