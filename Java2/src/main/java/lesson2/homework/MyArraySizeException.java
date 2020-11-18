package lesson2.homework;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
        System.out.println(message);
    }
}
