package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 【问题描述】
 * <p>
 * 一个多项式可以表示为一组数对，数对中第一个数始终为整数，
 * 且唯一，表示多项式的次数，另一数表示为对应的系数且不为0。输入两组数对，
 * 每组以0 0作为结束，实现对两个多项式的加法并按降幂输出结果数对
 * <p>
 * 【输入形式】
 * <p>
 * 每行输入一个数对，以空格为分隔符，以0 0结束
 * <p>
 * 【输出形式】
 * <p>
 * 每行输出一个数对，以空格为分隔符
 * <p>
 * 【样例输入】
 * <p>
 * 5 12
 * 3 8
 * 1 2
 * 15 5
 * 0 10
 * 0 0
 * 3 12
 * 30 1
 * 15 5
 * 0 0
 * 【样例输出】
 * <p>
 * 30 1
 * 15 10
 * 5 12
 * 3 20
 * 1 2
 * 0 10
 */
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
