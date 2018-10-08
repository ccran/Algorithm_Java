package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 9.
 * 【问题描述】
 * <p>
 * 为了用事实说明挖掘机技术到底哪家强，组织一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。
 * <p>
 * 【输入形式】
 * <p>
 * 输入在第1行给出不超过105的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，
 * 包括其所代表的学校的编号、及其比赛成绩（百分制），中间以空格分隔。
 * <p>
 * 【输出形式】
 * <p>
 * 在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
 * <p>
 * 【样例输入】
 * <p>
 * 6
 * 3 65
 * 2 80
 * 1 100
 * 2 70
 * 3 40
 * 3 0
 * <p>
 * 【样例输出】
 * <p>
 * 2 150
 * <p>
 * 【问题说明】
 * <p>
 * 建议练习使用STL中的map
 */
public class Test9 {
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
        int N = scanner.nextInt();
        //编号-成绩 键值对
        Map<String, Integer> codeGradeMap = new HashMap<>();
        String maxCode = "";
        int maxGrade = 0;
        for (int i = 0; i < N; i++) {
            //输入编号
            String code = scanner.next();
            int tmpGrade = scanner.nextInt();
            //放入成绩
            if (codeGradeMap.containsKey(code)) {
                int grade = codeGradeMap.get(code);
                codeGradeMap.put(code, grade + tmpGrade);
                if (grade + tmpGrade > maxGrade) {
                    maxGrade = grade + tmpGrade;
                    maxCode = code;
                }
            } else {
                codeGradeMap.put(code, tmpGrade);
                if (tmpGrade > maxGrade) {
                    maxGrade = tmpGrade;
                    maxCode = code;
                }
            }
        }
        System.out.println(maxCode + " " + maxGrade);
    }
}
