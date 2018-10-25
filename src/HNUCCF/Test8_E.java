package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 液晶数码管用七笔阿拉数字表示的十个数字，把横和竖的一 个短划都称为一笔，
 * 即７有３笔，８有７笔等。对于十个数字一种排列，要做到两相邻数字都可以由另一个数字加上几笔或减去几笔组成，
 * 但不能又加又减。比如 ７→３是允许的，７→２不允许。任意输入一组数，判断是否符合上述规则，注意，1在右边。
 * <p>
 * 【输入形式】
 * <p>
 * 每行输入一个0~9的排列，数字之间用空格分隔，以-1作为输入结束
 * <p>
 * 【输出形式】
 * <p>
 * 输出YES或NO
 * <p>
 * 【样例输入】
 * <p>
 * 4 1 0 7 3 9 5 6 8 2
 * 3 5 1 6 2 7 9 0 4 8
 * -1
 * 【样例输出】
 * <p>
 * YES
 * NO
 */
public class Test8 {
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
