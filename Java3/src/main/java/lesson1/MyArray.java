package lesson1;

public class MyArray implements C, D {

    private Object[] data;
    private int size, capacity;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public Object get(int index) {
        return data[index];
    }

    // [_] -> [_]
    public void set(int index, Object o) {
        data[index] = o;
    }

    // 1 2 3 4
    // 1 2 7 3 4
    public void add(Object o) {
        validateCapacity();
        data[size] = o;
        size++;
    }

    // 1 2 3 4
    // 1 3 4 4
    public void remove() {
        size--;
    }

    private void validateCapacity() {
        if (size == capacity - 1) {
            capacity *= 2;
            Object [] tmp = new Object[capacity];
            if (size >= 0) {
                System.arraycopy(data, 0, tmp, 0, size);
            }
            data = tmp;
        }
    }

    @Override
    public void foo() {

    }
}
