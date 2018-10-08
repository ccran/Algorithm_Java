package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 2.
 * 【问题描述】
 * <p>
 * 读入n名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 * <p>
 * 【输入形式】
 * <p>
 * 每个测试输入包含1个测试用例，格式为
 * <p>
 * 第1行：正整数n
 * 第2行：第1个学生的姓名 学号 成绩
 * 第3行：第2个学生的姓名 学号 成绩
 * ... ... ...
 * 第n+1行：第n个学生的姓名 学号 成绩
 * 其中姓名和学号均为不超过10个字符的字符串，成绩为0到100之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 * <p>
 * 【输出形式】
 * <p>
 * 对每个测试用例输出2行，第1行是成绩最高学生的姓名和学号，第2行是成绩最低学生的姓名和学号，字符串间有1空格。
 * <p>
 * 【样例输入】
 * <p>
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 * 【样例输出】
 * <p>
 * Mike CS991301
 * Joe Math990112
 */
public class Test2 {
    private static final boolean commit = true;

    static class Student implements Comparable<Student> {
        String name;
        String stuNum;
        int grade;

        //可用于多元条件的比对
        @Override
        public int compareTo(Student o) {
            return o.grade - this.grade;
        }

        @Override
        public String toString() {
            return name + " " + stuNum;
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
        //循环获取输入
        int line = scanner.nextInt();
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            Student student = new Student();
            //next方法读入的字符串无空格
            student.name = scanner.next();
            student.stuNum = scanner.next();
            student.grade = scanner.nextInt();
            studentList.add(student);
        }
        //通过Comparable接口进行排序
        Collections.sort(studentList);
        //最大
        System.out.println(studentList.get(0));
        //最小
        System.out.print(studentList.get(studentList.size() - 1));
    }
}
