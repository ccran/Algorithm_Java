import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class testClass = Class.forName("Test");
        Method setNameMethod = testClass.getMethod("setName",String.class);
        Test test1 = new Test(),test2=new Test();
        setNameMethod.invoke(test1,"hello");
        setNameMethod.invoke(test2,"nihao");
        System.out.println(setNameMethod.getParameterTypes()[0].equals(Integer.class));
        System.out.println(test1.getName());
        System.out.println(test2.getName());
    }
}
