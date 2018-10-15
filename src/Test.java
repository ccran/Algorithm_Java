import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void ReflectionTest(
            String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException

    {
        Class testClass = Class.forName("Test");
        Method setNameMethod = testClass.getMethod("setName", String.class);
        Test test1 = new Test(), test2 = new Test();
        setNameMethod.invoke(test1, "hello");
        setNameMethod.invoke(test2, "nihao");
        System.out.println(setNameMethod.getParameterTypes()[0].equals(Integer.class));
        System.out.println(test1.getName());
        System.out.println(test2.getName());
    }

    private static boolean commit = true;

    public static void main(String[] args) {
        String hello = "hello";
        String helloWorld = "hello world";
        System.out.println(Arrays.toString(hello.split(" ")));
        System.out.println(Arrays.toString(helloWorld.split(" ")));
    }

}
