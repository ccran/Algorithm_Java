package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 平面上有n个不同的点，没有在Y轴的点，检查是否存在这样一个点，将其删除后其余所有的点均位于Y轴的同一边。
 * 【输入形式】
 * <p>
 * 输入第一行包含一个正整数n(2<=n<=105)。
 * <p>
 * 接下来的n行，包含所有点的坐标，第i行包含两个整数xi和yi(|xi|、|yi|<=109，xi<>0)。
 * 【输出形式】
 * <p>
 * 如果存在这样的点，则输入"Yes"，否则输出"No"。
 * 【样例输入】
 * <p>
 * 3
 * 1 1
 * -1 -1
 * 2 -1
 * <p>
 * 【样例输出】
 * <p>
 * Yes
 */
public class Test40 {
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
        //循环获取输入
        int n = scanner.nextInt();
        int negative = 0, positive = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (x < 0)
                negative++;
            else
                positive++;
        }
        if (negative <= 1 || positive <= 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
