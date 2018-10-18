package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 【问题描述】
 * <p>
 * 程序设计考试结束了，传来个不好的消息：有一个学生没参加考试!需要尽快知道缺席考试的人是谁，以便尽快做出处理。
 * <p>
 * 糟糕的是，尽管有签到表，但由于人数较多，签到情况比较混乱：有的签到表签在一张白纸上，有的虽然签在名册上，
 * 但并不是签在自己姓名旁，更有学生签到了别的签到表上……
 * <p>
 * 现在只能根据这2n-1个姓名（名册上有n个学生姓名，签到有n-1个姓名，签到姓名和名册姓名可能混在一起了），
 * 来找到缺席考试的人是谁。唯一一个有利的条件是所有参加考试的人都签了名，且只签一次，签名也都正确无误。
 * <p>
 * 现在任务交给你：编写一个程序，找出缺席考试的是谁。
 * <p>
 * <p>
 * 【输入形式】
 * <p>
 * 有多组测试数据。
 * <p>
 * 每组测试数据开始一行，是一个正整数n，表示总人数，n=0意味着输入结束并且不需要处理。
 * <p>
 * 以下2n-1行，每行一个字符串，长度不超过20，表示一个人的姓名。姓名有大小写的英文字母、
 * 常用汉字组成(注意每个汉字占2个字节，中英文姓名都不排除有重名情况)。
 * <p>
 * 40%的测试数据1 ≤ n≤ 10；
 * <p>
 * 30%的测试数据1 ≤ n≤ 100；
 * <p>
 * 20%的测试数据1 ≤ n≤ 103；
 * <p>
 * 10%的测试数据1 ≤ n≤ 104；
 * <p>
 * 提示：大量输入数据，C/C++输入推荐使用scanf函数
 * <p>
 * <p>
 * 【输出形式】
 * <p>
 * 对于每组测试数据，输出一行，只包含一个字符串，表示缺席的人的姓名。
 * <p>
 * 【样例输入】
 * <p>
 * 2
 * 张三
 * 张三
 * 李四
 * 0
 * 【样例输出】
 * <p>
 * 李四
 */
public class Test38 {
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
        while (true) {
            //输入人数
            int n = scanner.nextInt();
            if (n == 0)
                break;
            scanner.nextLine();
            int sum = 2 * n - 1;
            //集合去重
            Set<String> nameSet = new HashSet<>();
            //输入名单名称
            for (int i = 0; i < sum; i++) {
                String name = scanner.nextLine();
                if (nameSet.contains(name)) {
                    nameSet.remove(name);
                } else {
                    nameSet.add(name);
                }
            }
            for (String name : nameSet) {
                System.out.println(name);
            }
        }
    }
}
