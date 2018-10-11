package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 【问题描述】
 * <p>
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
 * 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 * <p>
 * 【输入形式】
 * <p>
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * <p>
 * 【输出形式】
 * <p>
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出
 * <p>
 * 【样例输入】
 * <p>
 * 100311
 * 【样例输出】
 * <p>
 * 0:2
 * 1:3
 * 3:1
 */
public class Test25 {
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
        //数字统计
        String numStr = scanner.next();
        //TreeMap默认根据key升序排列
        Map<Character, Integer> chCntMap = new TreeMap<>();
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (!chCntMap.containsKey(ch)) {
                chCntMap.put(ch, 1);
            } else {
                int cnt = chCntMap.get(ch);
                chCntMap.put(ch, cnt + 1);
            }
        }
        //遍历结果
        for (Map.Entry<Character, Integer> entry : chCntMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
