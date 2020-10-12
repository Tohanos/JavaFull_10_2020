package lesson1;

import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        // [1, 12]
        if (x >= 1 && x <= 12) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // > < >= <= == !=
        boolean c1 = x != 10;
        boolean c2 = x > 12;
        boolean c3 = x < 120;
        if (c1 && c2 && c3) {}
        if (c1 || c2 || c3) {}

    }
}
