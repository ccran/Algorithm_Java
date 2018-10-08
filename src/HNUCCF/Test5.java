package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 5.
 * 【问题描述】
 * <p>
 * 从键盘接收用户输入的字符串, 对用户输入的每个字符串的处理是：将字符串内的每一个十进制数字字符置换成下列表格中右边所对应的一个字符串（所有其他字符不变），然后将转换的结果显示在屏幕上；并分别计算每个数字的置换次数。
 * <p>
 * 十进制数字字符
 * <p>
 * 置换成
 * <p>
 * 0
 * <p>
 * (Zero)
 * <p>
 * 1
 * <p>
 * (One)
 * <p>
 * 2
 * <p>
 * (Two)
 * <p>
 * 3
 * <p>
 * (Three)
 * <p>
 * 4
 * <p>
 * (Four)
 * <p>
 * 5
 * <p>
 * (Five)
 * <p>
 * 6
 * <p>
 * (Six)
 * <p>
 * 7
 * <p>
 * (Seven)
 * <p>
 * 8
 * <p>
 * (Eight)
 * <p>
 * 9
 * <p>
 * (Nine)
 * <p>
 * 例如，若用户输入的字符串为
 * <p>
 * Page112-Line3，
 * <p>
 * 则程序5的输出是：
 * <p>
 * Page(One) (One) (Two)-Line(Three),
 * <p>
 * 数字0到9的置换次数分别是  0 2 1 1 0 0 0 0 0 0
 * <p>
 * 【输入形式】
 * <p>
 * 输入一行字符串，其中可包含字母、数字、空格或其他符号（英文）
 * <p>
 * 【输出形式】
 * <p>
 * 第一行为将字符串中的数字转换为表格中的内容后输出
 * <p>
 * 第二行为数字0~9被转换的次数
 * <p>
 * 【样例输入】
 * <p>
 * Page112-Line3
 * 【样例输出】
 * <p>
 * Page(One)(One)(Two)-Line(Three)
 * 0 2 1 1 0 0 0 0 0 0
 */
public class Test5 {
    private static final boolean commit = true;
    private static String[] numString = {"(Zero)", "(One)", "(Two)", "(Three)", "(Four)"
            , "(Five)", "(Six)", "(Seven)", "(Eight)", "(Nine)"};
    private static int[] times = new int[10];

    public static String numToString(String inputStr) {
        StringBuilder sb = new StringBuilder(inputStr);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                int index = ch - '0';
                //计数
                times[index]++;
                //替换
                sb.replace(i, i + 1, numString[index]);
            }
        }
        return sb.toString();
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
        //接收line
        String inputStr = scanner.nextLine();
        System.out.println(numToString(inputStr));
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                System.out.print(times[i]);
            else
                System.out.print(" " + times[i]);
        }
        System.out.println();
    }
}
