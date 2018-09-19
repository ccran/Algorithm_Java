package Algorithm4th.List;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 测试ArrayList
 * 1.增加
 * add(Element elem) add(Element elem,int index) addAll(Collection<Element> c)
 * 2.删除
 * remove(int index) remove(Object obj) removeAll(Collection<Element> c)
 * 3.查询
 * get
 * 4.修改
 * set
 */
public class ArrayListTestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<String> arrayList1 = new ArrayList<>(0);
        ArrayList<String> arrayList2 = new ArrayList<>(0);
        Class clz1 = arrayList1.getClass(),clz2 = arrayList2.getClass();
        Field field1 = clz1.getDeclaredField("elementData"),field2 = clz2.getDeclaredField("elementData");
        field1.setAccessible(true);field2.setAccessible(true);
        System.out.println(field1.get(arrayList1));
        System.out.println(field2.get(arrayList2));
        Object[] tmp = {};
        System.out.println(tmp.length);
    }
}
