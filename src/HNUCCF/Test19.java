package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Test19 {
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
        //获取输入
        int sumLesson = scanner.nextInt();
        int[] point = new int[sumLesson];
        int[] score = new int[sumLesson];
        for(int i=0;i<sumLesson;i++){
            point[i]=scanner.nextInt();
        }
        for(int i=0;i<sumLesson;i++){
            score[i]=scanner.nextInt();
        }
    }
}
