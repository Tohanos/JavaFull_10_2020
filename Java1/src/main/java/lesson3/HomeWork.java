package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        int gameRepeat = 0;
        do {
            System.out.println("Выбери игру:");
            System.out.println("1 - угадай число    2 - угадай фрукт/овощ");
            int chosenGame = getIntFromScanner("Введи номер выбранной игры", 1, 2);
            switch (chosenGame) {
                case 1 -> guessNumber();
                case 2 -> guessFood();
            }
            gameRepeat = getIntFromScanner("Повторить игру? 1- да, 0 - нет", 0, 1);

        } while (gameRepeat == 1);
    }

    public static void guessFood() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        int wordIndex = rand.nextInt(words.length + 1);


        String stringInput = "";
        while (true) {
            stringInput = getStringFromScanner("Введите название съедобной культуры по-английски");
            if (stringInput.equals(words[wordIndex])) break;
            System.out.println("Ваша попытка:" + checkWord(stringInput, words[wordIndex]));
        }
        System.out.println("Вы угадали!");
    }

    public static void guessNumber() {

        int numberToGuess = rand.nextInt(10);
        int numberIn = -1;
        for (int i = 0; i < 3; i++) {
            System.out.println("Попытка №" + (i + 1));
            numberIn = getIntFromScanner("Введите число", 0, 9);
            if (numberIn == numberToGuess) {
                System.out.println("Правильно!");
                break;
            } else {
                System.out.println("Не угадали!");
                System.out.println("Загаданное число " +
                        (numberToGuess < numberIn ? "меньше" : "больше") +
                        " введённого");
            }
        }
        System.out.println("Было загадано число " + numberToGuess);
    }

    public static String checkWord(String stringIn, String stringOriginal) {
        char[] charsOut = new char[15];
        Arrays.fill(charsOut, '#');

        int lastIndex = Math.min(stringIn.length(), stringOriginal.length());
        for (int i = 0; i < lastIndex; i++) {
            if (stringIn.charAt(i) == stringOriginal.charAt(i)) {
                charsOut[i] = stringIn.charAt(i);
            } else {
                charsOut[i] = '#';
            }
        }
        return String.valueOf(charsOut);

    }

    public static String getStringFromScanner(String message) {
        System.out.println(message);
        return sc.next();
    }

    public static int getIntFromScanner(String message, int minInt, int maxInt) {
        System.out.println(message);
        System.out.println("Число должно лежать в диапазоне от " + minInt + " до " + maxInt);
        int inputInt;
        do {
            inputInt = sc.nextInt();
        } while (inputInt < minInt || inputInt > maxInt);
        return inputInt;
    }

}
