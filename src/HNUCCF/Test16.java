package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，
 * 则A的“6部分”PA是66，因为A中有2个6；给定A = 3862767，DA = 1，则A的“1部分”PA是0，因为A中有0个1。
 * <p>
 * 现给定A、DA、B、DB，请编写程序计算PA + PB。
 * <p>
 * 【输入形式】
 * <p>
 * 输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。
 * <p>
 * 【输出形式】
 * <p>
 * 在一行中输出PA + PB的值。
 * <p>
 * 【样例输入】
 * <p>
 * 3862767 6 13530293 3
 * 【样例输出】
 * <p>
 * 399
 */
public class Test16 {
    private static final boolean commit = true;

    //获取一个串的部分
    public static int getPart(String str, char ch) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 0)
            return 0;
        else {
            int res = 0, num = Integer.parseInt(String.valueOf(ch));
            while (cnt-- > 0) {
                res = res * 10 + num;
            }
            return res;
        }
    }

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
        //输入数据
        String aStr = scanner.next();
        char aCh = scanner.next().charAt(0);
        String bStr = scanner.next();
        char bCh = scanner.next().charAt(0);
        System.out.println(getPart(aStr, aCh) + getPart(bStr, bCh));
    }
}
