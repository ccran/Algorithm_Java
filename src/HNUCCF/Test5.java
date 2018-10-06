package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Test5 {
    private static final boolean commit = true;
    private static String[] numString = {"(Zero)", "(One)", "(Two)", "(Three)", "(Four)"
            , "(Five)", "(Six)", "(Seven)", "(Eight)", "(Nine)"};
    private static int[] times = new int[10];

    public static String numToString(String inputStr) {
        StringBuilder sb = new StringBuilder(inputStr);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                int index = ch - '0';
                //计数
                times[index]++;
                //替换
                sb.replace(i, i + 1, numString[index]);
            }
        }
        return sb.toString();
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
        //接收line
        String inputStr = scanner.nextLine();
        System.out.println(numToString(inputStr));
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                System.out.print(times[i]);
            else
                System.out.print(" " + times[i]);
        }
        System.out.println();
    }
}
