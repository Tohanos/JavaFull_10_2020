package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        int wordIndex = rand.nextInt(words.length + 1);


        String stringInput = "";
         do {
            stringInput = getStringFromScanner("Введите название съедобной культуры по-английски");
            System.out.println("Ваша попытка:" + checkWord(stringInput,words[wordIndex]));
        } while (!stringInput.equals(words[wordIndex]));
        System.out.println("Вы угадали!");

    }

    public static String checkWord(String stringIn, String stringOriginal) {
        char[] charsOut = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        int lastIndex = Math.min(stringIn.length(),stringOriginal.length());
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

}
