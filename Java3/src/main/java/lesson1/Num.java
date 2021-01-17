package lesson1;

import java.io.Closeable;
import java.io.IOException;

public class Num extends Number implements Closeable, Cloneable, Comparable<Number> {

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public int compareTo(Number o) {
        return 0;
    }
}
