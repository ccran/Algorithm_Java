package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 6.
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
 * 如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 * <p>
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如在图1中，
 * 第3串是小红想做的珠串；那么第1串可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * 第2串不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 * <p>
 * 【输入形式】
 * <p>
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 * <p>
 * 【输出形式】
 * <p>
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
 * <p>
 * 【样例输入】
 * <p>
 * ppRYYGrrYBR2258
 * YrR8RrY
 * <p>
 * 【样例输出】
 * <p>
 * Yes 8
 */
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
            if (beedCnt.containsKey(ch)) {
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
