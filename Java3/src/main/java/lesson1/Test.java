package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {

    // ? & extends super
    // ? - любой тип
    // [_] <- Integer
    // Object o = 1;
    // Number n = 1;
    // Integer i = 1;
    static <T> void getT(ArrayList<T> list) {
        System.out.println("1");
    }


    static <T> T getTT(ArrayList<? extends Throwable> list) {
        System.out.println("*");
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    static <T> T getT(T value) {
        System.out.println("2");
        return value;
    }

    static <R, T> R map(R value, T out) {
        return null;
    }

    public static void main(String[] args) {
        getT(new ArrayList<Object>());
        getTT(new ArrayList<>());
        MyArray array = new MyArray();
        array.add(12);
        array.add("12314");
        array.add(null);
        int value = ((Integer) array.get(0));
        //int value1 = (int) array.get(1);
        MyArrayGen<Number> arrayGen = new MyArrayGen<>();
        arrayGen.add(123);
        arrayGen.get(0);

        //C c = array;
        //D d = array;

//        A<Exception> a = new A<>();
//        a.setValue(new Exception());
//        System.out.println(a.getValue());
//        B<Num> b = new B<>();
//        // b.getValue();
//        Runnable r = () -> {
//
//        };
//        System.out.println(r.getClass());
        // Stream
        // .of("12", "123").map()

//        IntStream.range(1, 10).flatMap(i -> IntStream.range(0, i))
//                .forEach(System.out::println);

    }
}
