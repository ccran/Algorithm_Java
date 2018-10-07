package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Test10 {
    private static final boolean commit = true;

    //程序入口
    public static void main(String[] args) {
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
        Map<Integer, Integer> polynomialMap = new HashMap<>();
        //循环获取输入
        //多项式一
        while (true) {
            int exp = scanner.nextInt();
            int coeff = scanner.nextInt();
            if (exp == 0 && coeff == 0)
                break;
            polynomialMap.put(exp, coeff);
        }
        //多项式二
        while (true) {
            int exp = scanner.nextInt();
            int coeff = scanner.nextInt();
            if (exp == 0 && coeff == 0)
                break;
            if (polynomialMap.containsKey(exp)) {
                int old = polynomialMap.get(exp);
                polynomialMap.put(exp, old + coeff);
            } else {
                polynomialMap.put(exp, coeff);
            }
        }
        //排序输出
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(polynomialMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            //从大到小排序
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (entry.getValue() != 0)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
