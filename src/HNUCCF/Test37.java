package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 输出 包含n 或者是n的倍数的所有数
 * <p>
 * 【输入形式】
 * <p>
 * 正整数 m,n（0<m，n<1000000）
 * <p>
 * 【输出形式】
 * <p>
 * 从小到大排列的不大于 m 的特殊正整数（包含n，或者是n的倍数）。
 * <p>
 * 【样例输入1】
 * <p>
 * 20 7
 * 【样例输出1】
 * <p>
 * 7 14 17
 * 【样例输入2】
 * <p>
 * 200 11
 * 【样例输出2】
 * <p>
 * 11 22 33 44 55 66 77 88 99 110 111 112 113 114 115 116 117 118 119 121 132 143 154 165 176 187 198
 * 【样例说明】
 * <p>
 * 包含n的数可以考虑使用字符串查找解决
 */
public class Test37 {
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
        //输入mn
        int m = scanner.nextInt(), n = scanner.nextInt();
        String nStr = String.valueOf(n);
        boolean firstOutput = true;
        for (int i = 1; i <= m; i++) {
            //倍数
            if (i % n == 0) {
                if (firstOutput) {
                    System.out.print(i);
                    firstOutput = false;
                } else {
                    System.out.print(" " + i);
                }
            }
            //包含n
            else {
                String iStr = String.valueOf(i);
                if (iStr.contains(nStr)) {
                    if (firstOutput) {
                        System.out.print(i);
                        firstOutput = false;
                    } else {
                        System.out.print(" " + i);
                    }
                }
            }
        }
    }
}
