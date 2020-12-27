package lesson3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tests {

    public static void main(String[] args) throws IOException {
        // InputStream stream = Tests.class.getResourceAsStream("data.txt");
        OutputStream os = new FileOutputStream("out.txt", true);
        IoUtils.copyBuffered("video.mov", "video_copy.mov");

    }
}
