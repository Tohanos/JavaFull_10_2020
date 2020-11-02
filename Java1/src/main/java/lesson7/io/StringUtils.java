package lesson7.io;

import java.util.Arrays;

public class StringUtils {
    public static void main(String[] args) {
        //login@127.0.0.1:8080
        String email = "ooo.12@mail.ru";
        //[a-zA-Z0-9]{0,1}[a-zA-Z0-9._-]{1,31}@[a-zA-Z0-9._-]{0,32}\\.[a-z0-9]{2,5}
        String phone = "+7(911)275-89-87";
        // matches, split, replace
        String[] parts = phone.split("[()-]");
        parts[0] = parts[0].replaceAll("\\+", "");
        System.out.println(Arrays.toString(parts));

        // String StringBuilder

        String s = "a";
        // s ->    'f''a''s'...  + 'a''s''f'...
        // s <-    'f''a''s'... 'a''s''f'...
        // O(N * N)
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("time String: " + (end - start) + " ms.");
        start = System.currentTimeMillis();
        // O(N * logN)
        StringBuilder sb = new StringBuilder("a");
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("time String: " + (end - start) + " ms.");

    }
}
