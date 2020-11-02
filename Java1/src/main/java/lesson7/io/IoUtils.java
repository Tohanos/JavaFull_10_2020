package lesson7.io;

import java.awt.event.PaintEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class IoUtils {

    private static final String PREFIX = "root_dir/";

    public static void readData(String fileName) throws IOException {
        File file = new File(PREFIX + fileName);
        FileInputStream fis = new FileInputStream(file);

        // false default override mode
        // true -> append mode
        FileOutputStream fos = new FileOutputStream(
                new File(PREFIX + "copy.m4v"));
        fis.transferTo(fos);
        fis.close();
        fos.close();
//        StringBuilder sb = new StringBuilder();
//        int cur;
//        byte[] buffer = new byte[8192]; // 256
//        //xmx 512Mb
//        while ((cur = fis.read(buffer)) != -1) {
////            for (int i = 0; i < 8192; i++) {
////                sb.append((char) buffer[i]);
////            }
//            fos.write(buffer, 0 , cur);
//        }
//        fis.close();
//        fos.close();
        // System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        readData("big_file.m4v");
    }
}
