import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

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

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean commit = false;
        InputStream inputStream = null;
        //从文件流读取输入
        if (!commit) {
            try {
                inputStream = new FileInputStream("F:\\in.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            inputStream = System.in;
        }
        Scanner scanner = new Scanner(inputStream);
        int i = scanner.nextInt();
        System.out.println("i:" + i);
        String str = scanner.nextLine();
        System.out.println("str:" + str);
        str = scanner.nextLine();
        System.out.println("str:" + str);
    }
}
