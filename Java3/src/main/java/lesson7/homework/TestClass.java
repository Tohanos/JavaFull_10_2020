package lesson7.homework;

public class TestClass {

    @BeforeSuite
    public void before() {
        System.out.println("Before testing");
    }

    @AfterSuite
    public void after() {
        System.out.println("After testing");
    }


    @Test (priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test (priority = 2)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test (priority = 3)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test (priority = 5)
    public void test5() {
        System.out.println("Test 5");
    }

    @Test (priority = 7)
    public void test7() {
        System.out.println("Test 7");
    }

    @Test (priority = 10)
    public void test10() {
        System.out.println("Test 10");
    }

    @Test (priority = 1)
    public void test11() {
        System.out.println("Test 11");
    }

    @Test (priority = 2)
    public void test12() {
        System.out.println("Test 12");
    }

}
