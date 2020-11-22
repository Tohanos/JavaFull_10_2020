package lesson3.homweork;

import lesson3.CollectionExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class StringArrayCalc {

    public static HashMap<String, Integer> getWords(String path) {
        Scanner in = new Scanner(
                CollectionExamples.class.getResourceAsStream(path));
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (in.hasNextLine()) {
            String[] data = in.nextLine().split(",");
            Arrays.asList(data).forEach(b -> hashMap.put(b,hashMap.getOrDefault(b,0) + 1));
        }
        return hashMap;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashSet = getWords("words.txt");
        System.out.println(hashSet);


    }


}
