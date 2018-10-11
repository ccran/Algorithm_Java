package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * Gardon 昨天给小希布置了一道作业，即根据一张由不超过 5000 的 N(3<=N<=100)个正整数组成的数表两两相加得到 N*(N-1)/2 个和，
 * 然后再将它们排序。例如，如果数表里含有四个数 1，3，4，9，那么正确答案是 4，5，7，10，12，13。
 * 小希做完作业以后出去玩了一阵，可是下午回家时发现原来的那张数表不见了，好在她做出的答案还在，
 * 你能帮助她根据她的答案计算出原来的数表么？
 * <p>
 * 【输入形式】
 * <p>
 * 包含多组数据，每组数据以一个 N 开头，接下来的一行有按照大小顺序排列的 N*(N-1)/2 个数，
 * 是小希完成的答案。文件最后以一个 0 结束。
 * 假设输入保证解的存在性和唯一性。
 * <p>
 * 【输出形式】
 * <p>
 * 对于每组数据，输出原来的数表。它们也应当是按照顺序排列的。
 * <p>
 * 【样例输入】
 * <p>
 * 4
 * 4 5 7 10 12 13
 * 4
 * 5 6 7 8 9 10
 * 0
 * 【样例输出】
 * <p>
 * 1 3 4 9
 * 2 3 4 6
 */
public class Test23 {
    private static final boolean commit = false;

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
        while (scanner.hasNext()) {
            //do something
        }
    }
}
