package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    private static final boolean commit = true;
    private static final String[] chinese = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi"};

    //计算字符串
    public static int calcString(String numStr) {
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return sum;
    }

    //获取数字对应的中文字符串数组
    public static List<String> getStrArray(int num) {
        List<String> res = new ArrayList<>();
        if (num == 0) {
            res.add(chinese[0]);
            return res;
        }
        while (num != 0) {
            res.add(chinese[num % 10]);
            num /= 10;
        }
        return res;
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
        //输入自然数
        String numStr = scanner.next();
        //获取数字
        int sum = calcString(numStr);
        //按要求输出
        List<String> res = getStrArray(sum);
        for (int i = res.size() - 1; i >= 0; i--) {
            if (i == res.size() - 1)
                System.out.print(res.get(i));
            else
                System.out.print(" " + res.get(i));
        }
        System.out.println();
    }
}
