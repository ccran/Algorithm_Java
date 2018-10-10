package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Test18 {
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
        //计数器
        int cnt = 1;
        //循环获取输入
        while (true) {
            int nameNum = scanner.nextInt();
            if (nameNum == 0)
                break;
            scanner.nextLine();
            String[] nameArray = new String[nameNum];
            boolean isOdd = (nameNum % 2 != 0);
            int end = isOdd ? nameNum / 2 : nameNum / 2 - 1;
            for (int i = 0; i <= end; i++) {
                if (i == end && isOdd) {
                    nameArray[i] = scanner.nextLine();
                } else {
                    nameArray[i] = scanner.nextLine();
                    nameArray[nameNum - 1 - i] = scanner.nextLine();
                }
            }
            //输出结果
            System.out.println("set-" + (cnt++));
            for (int i = 0; i < nameNum; i++) {
                System.out.println(nameArray[i]);
            }
        }
    }
}
