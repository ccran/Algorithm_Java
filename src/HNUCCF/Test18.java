package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 你在信天翁马戏团（是的，它是由一群小丑组成）从事管理工作，
 * 你刚刚写完一个程序的输出是将他们的姓名按长度为非递减的方式排列，名称列表（使每名至少只要它之前的）。
 * 然而，你的老板不喜欢这种输出方式，而是希望输出出现更对称，较短的字符串在顶部和底部，而较长的字符串在中间。
 * 他的规则是，每一对名称都是在该列表的相对的两端，并且在该组中的第一个名字总是在列表的顶部。
 * 比如在下面的第一个例子中，Bo和Pat是第一对，Jean和Kevin是第二对，等等。
 * <p>
 * 【输入形式】
 * <p>
 * 输入由1到多个字符串集合组成，最后一行为0表示输入结束，每个集合开始于一个整数n，表示该集合字符串的个数，
 * 接下来n行由n个字符串按长度非递减的方式排列，每个集合至少包含一个但不超过15个字符串，每个字符串不超过25个字符。
 * <p>
 * 【输出形式】
 * <p>
 * 对于每个集合，第一行输出"set-n", n从1开始，接下来的若干行对应输入每个集合重新排列的结果，如样例所示。
 * <p>
 * 【样例输入】
 * <p>
 * 7
 * Bo
 * Pat
 * Jean
 * Kevin
 * Claude
 * William
 * Marybeth
 * 6
 * Jim
 * Ben
 * Zoe
 * Joey
 * Frederick
 * Annabelle
 * 5
 * John
 * Bill
 * Fran
 * Stan
 * Cece
 * 0
 * 【样例输出】
 * <p>
 * set-1
 * Bo
 * Jean
 * Claude
 * Marybeth
 * William
 * Kevin
 * Pat
 * set-2
 * Jim
 * Zoe
 * Frederick
 * Annabelle
 * Joey
 * Ben
 * set-3
 * John
 * Fran
 * Cece
 * Stan
 * Bill
 */
public class Test18 {
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
        //计数器
        int cnt = 1;
        //循环获取输入
        while (true) {
            int nameNum = scanner.nextInt();
            if (nameNum == 0)
                break;
            scanner.nextLine();
            String[] nameArray = new String[nameNum];
            boolean isOdd = (nameNum % 2 != 0);
            int end = isOdd ? nameNum / 2 : nameNum / 2 - 1;
            for (int i = 0; i <= end; i++) {
                if (i == end && isOdd) {
                    nameArray[i] = scanner.nextLine();
                } else {
                    nameArray[i] = scanner.nextLine();
                    nameArray[nameNum - 1 - i] = scanner.nextLine();
                }
            }
            //输出结果
            System.out.println("set-" + (cnt++));
            for (int i = 0; i < nameNum; i++) {
                System.out.println(nameArray[i]);
            }
        }
    }
}
