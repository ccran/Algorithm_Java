package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 【问题描述】
 * <p>
 * 在一个有200人的大班级中，存在两个人生日相同的概率非常大，现给出每个学生的学号，出生月日，试找出所有生日相同的学生。
 * <p>
 * 【输入形式】
 * <p>
 * 第一行为整数n，表示有n个学生，n<=200。此后每行包含一个字符串和两个整数，
 * 分别表示学生的学号(字符串长度为11位)和出生月(1<=m<=12)日(1<=d<=31)，学号、月、日之间用一个空格分隔。
 * <p>
 * 【输出形式】
 * <p>
 * 对每组生日相同的学生，输出一行，其中前两个数字表示月和日，后面跟着所有在当天出生的学生的学号，
 * 数字、学号之间都用一个空格分隔。对所有的输出，要求按日期从前到后的顺序输出。对生日相同的学号，按输入的顺序输出。
 * <p>
 * 【样例输入】
 * <p>
 * 6
 * 07101020105 3 15
 * 07101020115 4 5
 * 07101020118 3 15
 * 07101020108 4 5
 * 07101020111 4 5
 * 07101020121 8 10
 * 【样例输出】
 * <p>
 * 3 15 07101020105 07101020118
 * 4 5 07101020115 07101020108 07101020111
 * 8 10 07101020121
 */
public class Test26 {
    private static final boolean commit = true;

    public static class Birth implements Comparable<Birth> {
        public int month;
        private int day;

        @Override
        public int compareTo(Birth o) {
            if (this.month != o.month) {
                return this.month - o.month;
            } else {
                return this.day - o.day;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj instanceof Birth) {
                Birth birth = (Birth) obj;
                return this.month == birth.month && this.day == birth.day;
            }
            return false;
        }

        @Override
        public String toString() {
            return month + " " + day;
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
        int studentNum = scanner.nextInt();
        Map<Birth, List<String>> birthNumMap = new TreeMap<>();
        for (int i = 0; i < studentNum; i++) {
            String id = scanner.next();
            Birth birth = new Birth();
            birth.month = scanner.nextInt();
            birth.day = scanner.nextInt();
            if (!birthNumMap.containsKey(birth)) {
                List<String> idList = new ArrayList<>();
                idList.add(id);
                birthNumMap.put(birth, idList);
            } else {
                birthNumMap.get(birth).add(id);
            }
        }
        //输出结果
        for (Map.Entry<Birth, List<String>> entry : birthNumMap.entrySet()) {
            System.out.print(entry.getKey());
            for(String id:entry.getValue()){
                System.out.print(" "+id);
            }
            System.out.println();
        }
    }
}
