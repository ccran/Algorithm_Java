package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】输出 7 和 7 的倍数，还有包含 7 的数字例如（17，27，37...70，71，72，73...）
 * <p>
 * 【输入形式】一个正整数 N。(N 不大于 30000)
 * <p>
 * 【输出形式】从小到大排列的不大于 N 的与 7 有关的正整数，每行一个。
 * <p>
 * 【样例输入】
 * <p>
 * 20
 * <p>
 * 【样例输出】
 * <p>
 * 7
 * 14
 * 17
 */
public class Test28 {
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
        //正整数N
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            } else {
                if (String.valueOf(i).contains("7")) {
                    System.out.println(i);
                }
            }
        }
    }
}
