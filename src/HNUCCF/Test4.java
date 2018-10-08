package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4.
 * 【问题描述】
 * <p>
 * 读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 * <p>
 * 【输入形式】
 * <p>
 * 每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10的100次方。
 * <p>
 * 【输出形式】
 * <p>
 * 在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。
 * <p>
 * 【样例输入】
 * <p>
 * 1234567890987654321123456789
 * 【样例输出】
 * <p>
 * yi san wu
 * 【样例说明】
 * 友情提示汉语拼音
 * <p>
 * 0~9：ling yi er san si wu liu qi ba jiu shi
 */
public class Test4 {
    private static final boolean commit = true;
    private static final String[] chinese = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi"};

    //计算字符串
    public static int calcString(String numStr) {
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return sum;
    }

    //获取数字对应的中文字符串数组
    public static List<String> getStrArray(int num) {
        List<String> res = new ArrayList<>();
        if (num == 0) {
            res.add(chinese[0]);
            return res;
        }
        while (num != 0) {
            res.add(chinese[num % 10]);
            num /= 10;
        }
        return res;
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
        //输入自然数
        String numStr = scanner.next();
        //获取数字
        int sum = calcString(numStr);
        //按要求输出
        List<String> res = getStrArray(sum);
        for (int i = res.size() - 1; i >= 0; i--) {
            if (i == res.size() - 1)
                System.out.print(res.get(i));
            else
                System.out.print(" " + res.get(i));
        }
        System.out.println();
    }
}
