package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test6 {
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
        //输入珠串
        String existBeed = scanner.nextLine();
        String wantBeed = scanner.nextLine();
        //保存所需珠串
        Map<Character, Integer> beedCnt = new HashMap<>();
        for (int i = 0; i < wantBeed.length(); i++) {
            char ch = wantBeed.charAt(i);
            /**
             * map的getOrDefault方法为JDK8新增,导致低版本编译错误
             */
            int cnt = 0;
            if(beedCnt.containsKey(ch)){
                cnt = beedCnt.get(ch);
            }
            beedCnt.put(ch, cnt + 1);
        }
        //遍历存在串
        for (int i = 0; i < existBeed.length(); i++) {
            char ch = existBeed.charAt(i);
            if (beedCnt.containsKey(ch)) {
                int cnt = beedCnt.get(ch);
                beedCnt.put(ch, cnt - 1);
            }
        }
        //遍历次数map
        boolean enoughBeed = true;
        int cnt = 0;
        for (Integer times : beedCnt.values()) {
            if (times > 0) {
                enoughBeed = false;
                cnt += times;
            }
        }
        //输出结果
        if (enoughBeed) {
            System.out.println("Yes " + (existBeed.length() - wantBeed.length()));
        } else {
            System.out.println("No " + cnt);
        }
    }
}
