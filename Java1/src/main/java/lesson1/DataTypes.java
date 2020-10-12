package lesson1;

public class DataTypes {
    public static void main(String[] args) {
        // целые
        byte b = 127; // 1b [-128, 127]
        short s = 32767; // 2b [-32768, 32767] 2 ** 15
        int i = 2_000_000_000; // 4b 2 ** 31 (2 * 10 ** 9)
        long l = 2_000_000_000_000_000_000L; // 8b 2 ** 63 (9 * 10 ** 18)
        System.out.println(b + " " + s + " " + i + " " + l);
        // вещественные
        float f = 0.6f; // 4b
        double d = 0.14; // 8b
        System.out.printf("%.20f\n", 1 / 3.);
        System.out.printf("%.20f\n", 1 / 3f);
        System.out.printf("%d %.5f %c\n", 12, 0.1, 'a');

        boolean bool = true; // true, false

        char sym = '&'; // \'"
        char sum1 = '\'';
    }
}
