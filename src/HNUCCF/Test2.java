package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
