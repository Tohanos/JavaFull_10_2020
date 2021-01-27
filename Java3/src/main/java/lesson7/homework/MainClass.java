package lesson7.homework;

public class MainClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        TestService.start(testClass.getClass());
    }
}
