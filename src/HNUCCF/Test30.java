package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 定义一个字符串的无序度为所有位置后面的字母比该位置的字母小的总数之和。比如"DAABEC''这个字符串的无序度是5，
 * 因为D后面有4个位置比它小（AABC），E后面有1个比它小（C），其它位置后面没有比自己小的。
 * " AACEDGG "的无序度为1（E后面有一个D比它小）。" ZWQM "的无序度为6，每个位置后面所有的字母都比它小。
 * 现在你的任务是给定一些字符串（只由大写字母组成），把他们按照无序度从小到大排序，
 * 如果无序度一样，那么就按照输入的相对顺序排序。
 * <p>
 * 【输入形式】
 * <p>
 * 单组测试数据。
 * 第一行有两个整数n(0 < n <= 50)和m (0 < m <= 100)，分别表示输入的字符串的长度和字符串的个数。
 * 接下来m行，每一行包含一个长度为n的字符串，只由大写字母组成。
 * 【输出形式】
 * <p>
 * 输出m行，表示排序之后的字符串。
 * 【样例输入】
 * <p>
 * 10 6
 * AACATGAAGG
 * TTTTGGCCAA
 * TTTGGCCAAA
 * GATCAGATTT
 * CCCGGGGGGA
 * ATCGATGCAT
 * 【样例输出】
 * <p>
 * CCCGGGGGGA
 * AACATGAAGG
 * GATCAGATTT
 * ATCGATGCAT
 * TTTTGGCCAA
 * TTTGGCCAAA
 */
public class Test30 {
    //定义含有无序度的类
    public static class UnSeq implements Comparable<UnSeq> {
        String strMem;
        int unSeqNum;

        //构造方法初始化无序度
        public UnSeq(String strMem) {
            this.strMem = strMem;
            this.unSeqNum = getUnSeqNumByStr(strMem);
        }

        //算出无序度
        public int getUnSeqNumByStr(String str) {
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) < str.charAt(i)) {
                        res++;
                    }
                }
            }
            return res;
        }

        @Override
        public int compareTo(UnSeq o) {
            return this.unSeqNum - o.unSeqNum;
        }

        @Override
        public String toString() {
            return strMem;
        }
    }

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
        int length = scanner.nextInt();
        int num = scanner.nextInt();
        scanner.nextLine();
        List<UnSeq> unSeqList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            unSeqList.add(new UnSeq(scanner.nextLine()));
        }
        //排序后输出
        //该方法排序是稳定的，故符合题目要求：按照输入的相对顺序排序
        Collections.sort(unSeqList);
        for (UnSeq unSeq : unSeqList) {
            System.out.println(unSeq);
        }
    }
}
