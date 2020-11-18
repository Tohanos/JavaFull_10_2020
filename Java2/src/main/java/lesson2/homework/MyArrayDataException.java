package lesson2.homework;

public class MyArrayDataException extends Exception{

    public MyArrayDataException() {
    }

    public MyArrayDataException(String message) {
        super(message);
        System.out.println(message);
    }
}
