package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //1
        int[] nElems = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < nElems.length; i++) {
            if (nElems[i] == 1) {
                nElems[i] = 0;
            } else {
                nElems[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nElems));
        //2

        int[] kElems = new int[8];
        for (int i = 0; i < 8; i++) {
            kElems[i] = i*3;
        }
        System.out.println(Arrays.toString(kElems));

        //3
        int[] lELems = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < lELems.length; i++) {
            if (lELems[i] < 6) lELems[i] *= 2;
        }
        System.out.println(Arrays.toString(lELems));

        //4
        int size = sizeInput("Введите размер квадратной матрицы");

        int[][] square = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i == (size - j - 1)) square[i][j] = 1;
                else square[i][j] = 0;
                System.out.print(square[i][j]);
            }
            System.out.println();
        }

        //5
        size = sizeInput("Введите размер массива");
        int[] arrayToCheck = new int[size];
        arrayInput(arrayToCheck);
        int elemMin = 0, elemMax = 0;
        for (int i = 0; i < size; i++) {
            if(i==0) {
                elemMin = arrayToCheck[i];
                elemMax = arrayToCheck[i];
            } else {
                if(elemMin > arrayToCheck[i]) elemMin = arrayToCheck[i];
                if(elemMax < arrayToCheck[i]) elemMax = arrayToCheck[i];
            }
        }
        System.out.println("Минимальное значение = "+elemMin+" Максимальное значение =" + elemMax);

        //6

        size = sizeInput("Введите размер массива");
        arrayToCheck = new int[size];
        arrayInput(arrayToCheck);
        System.out.println(leftAndRightSumsEquals(arrayToCheck));

        //7
        int shift = sizeInput("Введите сдвиг для массива");
        arrayRotate(arrayToCheck,shift);
        System.out.println(Arrays.toString(arrayToCheck));


    }

    public static int sizeInput(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        int size = sc.nextInt();
        return size;
    }

    public static void arrayInput(int[] array) {
        Scanner sc = new Scanner(System.in);
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.println("Введите "+ (i+1) +"-й элемент массива");
            array[i] = sc.nextInt();
        }
    }

    public static boolean leftAndRightSumsEquals(int[] arrayToCheck) {
        int size = arrayToCheck.length;
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) sumLeft +=arrayToCheck[j];
            for (int j = size-1; j > i; j--) sumRight += arrayToCheck[j];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    public static void arrayRotate(int[] inArray,int n){
        int size = inArray.length;
        int bucket;     //переменная для хранения изменяемого элемента массива

        int curCounter = 0;
        while(curCounter != n){

            if(n<0) {
                //сдвиг влево
                bucket = inArray[0];
                for (int i = 1; i < size; i++) inArray[i-1] = inArray[i];
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


