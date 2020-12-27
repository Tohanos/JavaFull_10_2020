package lesson1;

public class MyArrayGen<T extends Number> {

    private Object[] data;
    private int size, capacity;

    public MyArrayGen() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    // [_] -> [_]
    public void set(int index, T o) {
        data[index] = o;
    }

    // 1 2 3 4
    // 1 2 7 3 4
    public void add(T o) {
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
}
