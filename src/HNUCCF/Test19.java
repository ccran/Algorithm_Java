package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 学校对本科生的成绩施行绩点制（GPA）。将学生的实际考分根据不同学科的不同学分按一定的公式进行计算。规定如下：
 * <p>
 * 实际成绩        绩点
 * <p>
 * 90-100          4.0
 * <p>
 * 85-89            3.7
 * <p>
 * 82-84            3.3
 * <p>
 * 78-81            3.0
 * <p>
 * 75-77            2.7
 * <p>
 * 72-74            2.3
 * <p>
 * 68-71            2.0
 * <p>
 * 64-67            1.5
 * <p>
 * 60-63            1.0
 * <p>
 * 60以下            0
 * <p>
 * 1. 一门课程的学分绩点=该课绩点*该课学分
 * <p>
 * 2. 总评绩点=所有学科绩点之和/所有课程学分之和
 * <p>
 * 现要求你编程求出某人的总评绩点(GPA)
 * <p>
 * 【输入形式】
 * <p>
 * 第一行 总的课程数n
 * <p>
 * 第二行 相应课程的学分（两个学分间用空格隔开）
 * <p>
 * 第三行 对应课程的实际得分
 * <p>
 * 此处输入的所有数字均为整数
 * <p>
 * 【输出形式】
 * <p>
 * 输出有一行，总评绩点，保留两位小数
 * <p>
 * 【样例输入】
 * <p>
 * 5
 * 4 3 4 2 3
 * 91 88 72 69 56
 * 【样例输出】
 * <p>
 * 2.52
 */
public class Test19 {
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
        //获取输入
        int sumLesson = scanner.nextInt();
        //学分
        int[] score = new int[sumLesson];
        int sumScore = 0;
        for (int i = 0; i < sumLesson; i++) {
            score[i] = scanner.nextInt();
            sumScore += score[i];
        }
        //成绩
        double sumScorePoint = 0;
        for (int i = 0; i < sumLesson; i++) {
            int grade = scanner.nextInt();
            double point = 0;
            if (grade >= 90 && grade <= 100) {
                point = 4.0;
            } else if (grade >= 85 && grade <= 90) {
                point = 3.7;
            } else if (grade >= 82 && grade <= 84) {
                point = 3.3;
            } else if (grade >= 78 && grade <= 81) {
                point = 3.0;
            } else if (grade >= 75 && grade <= 77) {
                point = 2.7;
            } else if (grade >= 72 && grade <= 74) {
                point = 2.3;
            } else if (grade >= 68 && grade <= 71) {
                point = 2.0;
            } else if (grade >= 64 && grade <= 67) {
                point = 1.5;
            } else if (grade >= 60 && grade <= 63) {
                point = 1.0;
            }
            sumScorePoint += point * score[i];
        }
        System.out.println(String.format("%.2f", sumScorePoint / sumScore));
    }
}
