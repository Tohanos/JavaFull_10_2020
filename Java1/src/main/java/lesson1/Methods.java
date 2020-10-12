package lesson1;

import java.util.Scanner;

public class Methods {

    public static int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    // calculate

    // isLeap

    public static boolean isPositive(int x) {
        return x >= 0;
    }

    public static int f(int x) {
        double y = x * 15;
        return (int) y;
    }

    public static void print(int a, int b) {
        System.out.println("a = " + a + ", b = " + b);
    }

    // type name(p_type name_1, p_type name2 ...)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        print(a, b);
        int res = max(a, b);
        System.out.println(res);
        res++;
        System.out.println(res);
        res *= 5;
        System.out.println(res);
    }
}
