package lesson1;

import java.io.Closeable;
import java.io.Serializable;

public class B <T extends Number & Serializable & Cloneable & Closeable & Comparable<? extends Number>> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
