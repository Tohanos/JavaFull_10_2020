package lesson4;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test3 {

    static String s = "str";

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Object mon = new Object();
        //executor.execute(new ClientHandler());
        for (int i = 0; i < 100; i++) {
            executor.execute(new CustomRunner(i, mon, s + i));
        }
        executor.shutdownNow();
    }
}
