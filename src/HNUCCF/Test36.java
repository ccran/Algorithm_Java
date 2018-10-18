package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 汤姆对他最喜欢的笔记本电脑的耗电量很感兴趣。他的笔记本电脑有三种模式。
 * 在正常模式下，笔记本电脑每分钟消耗P1瓦。在汤姆最后一次移动鼠标或触摸键盘后的T1分钟，屏幕保护程序启动，
 * 每分钟的功耗变化为P2瓦。最后，从屏幕保护程序启动到T2分钟后，笔记本电脑切换到“睡眠”模式，每分钟消耗P3瓦。
 * 当笔记本电脑处于第二或第三模式时，如果汤姆移动鼠标或触摸键盘，则切换到第一种(正常)模式。
 * 汤姆使用笔记本电脑工作的时间可以分为n个时间间期[l1, r1]、[l2, r2]、...、[ln, rn]。
 * 在每个间期，汤姆连续移动鼠标并按下键盘。 在间期之间，汤姆什么都不做。请找出在间期[l1, rn]笔记本电脑的总耗电量。
 * <p>
 * 【输入形式】
 * <p>
 * 第一行包含6个整数n、P1、P2、P3、T1、T2(1<=n<=100，0<=P1、P2、P3<=100，1<=T1、T2<=60)。
 * 接下来的n行包含了汤姆工作的期间，第i行是两个用空格分隔的整数li和ri(0<=li<=ri<=1440, 当i<n时ri<li+1）,
 * 表示工作期间的开始时间和结束时间。
 * <p>
 * 【输出形式】
 * <p>
 * 输出总的耗电量。
 * 【样例输入】
 * <p>
 * 2 8 4 2 5 10
 * 20 30
 * 50 100
 * <p>
 * 【样例输出】
 * <p>
 * 570
 */
public class Test36 {
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
        int n = scanner.nextInt(), p1 = scanner.nextInt(), p2 = scanner.nextInt(), p3 = scanner.nextInt(), t1 = scanner.nextInt(), t2 = scanner.nextInt();
        int[] left = new int[n], right = new int[n];
        //总耗电量
        int sumUse = 0;
        //工作时间耗电量
        for (int i = 0; i < n; i++) {
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
            sumUse += (right[i] - left[i]);
        }
        sumUse *= p1;
        //空余时间耗电量
        for (int i = 0; i < n - 1; i++) {
            int gap = left[i + 1] - right[i];
            if (gap <= t1) {
                sumUse += gap * p1;
            } else if (gap > t1 && gap <= t1 + t2) {
                sumUse += t1 * p1 + (gap - t1) * p2;
            } else {
                sumUse += t1 * p1 + t2 * p2 + (gap - t1 - t2) * p3;
            }
        }
        //输出结果
        System.out.println(sumUse);
    }
}
