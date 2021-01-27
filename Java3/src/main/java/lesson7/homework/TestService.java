package lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestService {

    private static Object object;


    public static void start(Class clazz) {

        ArrayList<Method>[] methodsWithPriority;
        Method beforeSuite = null;
        Method afterSuite = null;

        try {
            object = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        methodsWithPriority = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            methodsWithPriority[i] = new ArrayList<>();
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuite == null) {
                    beforeSuite = method;
                    continue;
                } else {
                    throw new RuntimeException("Too many beforeSuite methods!");
                }
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterSuite == null) {
                    afterSuite = method;
                    continue;
                } else {
                    throw new RuntimeException("Too many afterSuite methods!");
                }
            }
            if (method.getAnnotation(Test.class) != null) {
                methodsWithPriority[method.getAnnotation(Test.class).priority() - 1].add(method);
            }

        }

        try {
            beforeSuite.invoke(object);
            for (int i = 0; i < 10; i++) {
                for (Method method : methodsWithPriority[i]) {
                    method.invoke(object);
                }
            }
            afterSuite.invoke(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

