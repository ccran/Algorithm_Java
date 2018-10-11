package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 给定一组正整数，其中最大值和最小值分别为Max和Min, 其中一个数x到Max和Min的距离差定义为：
 * <p>
 * abs(abs(x-Max)-(x-Min))
 * <p>
 * 其中abs()为求一个数的绝对值
 * <p>
 * 【输入形式】
 * <p>
 * 包括两行，第一行一个数n，表示第二行有n个正整数
 * <p>
 * 【输出形式】
 * <p>
 * 输出一个数x，该数在所有n个数中的距离差最小；如果有两个数的距离差都是最小，输出较小的哪个
 * <p>
 * 【样例输入1】
 * <p>
 * 5
 * 3 1 7 5 9
 * 【样例输出1】
 * <p>
 * 5
 * 【样例输入2】
 * <p>
 * 3
 * 1 3 2
 * 【样例输出2】
 * <p>
 * 2
 */
public class Test22 {
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
        //输入n以及n个正整数
        int n = scanner.nextInt();
        int[] num = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            if (max < num[i]) {
                max = num[i];
            }
            if (min > num[i]) {
                min = num[i];
            }
        }
        //计算最小距离差
        int minDistance = Integer.MAX_VALUE;
        int x = -1;
        for (int i = 0; i < n; i++) {
            //计算当前数的距离
            int distance = Math.abs(Math.abs(num[i] - max) - (num[i] - min));
            if (distance < minDistance) {
                x = num[i];
                minDistance = distance;
            } else if (distance == minDistance) {
                ///距离相同取较小的值
                if (num[i] < x) {
                    x = num[i];
                }
            }
        }
        System.out.println(x);
    }
}
