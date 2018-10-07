package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

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
