package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 3.
 * 【问题描述】这是一个古老而又经典的问题。用给定的几种钱币凑成某个钱数，一般而言有多种方式。
 * 例如：给定了 6 种钱币面值为 2、5、10、20、50、100，用来凑 15 元，可以用 5 个 2 元、1个 5 元，
 * 或者 3 个 5 元，或者 1 个 5 元、1个 10 元，等等。显然，最少需要 2 个钱币才能凑成 15 元。
 * 你的任务就是，给定若干个互不相同的钱币面值，编程计算，最少需要多少个钱币才能凑成某个给出的钱数。
 * <p>
 * 【输入形式】输入可以有多个测试用例。每个测试用例的第一行是待凑的钱数值 M（1 <= M<= 2000，整数），
 * 接着的一行中，第一个整数 K（1 <= K <= 10）表示币种个数，随后是 K个互不相同的钱币面值 Ki(1 <= Ki <= 1000)。
 * 输入 M=0 时结束。
 * <p>
 * 【输出形式】每个测试用例输出一行，即凑成钱数值 M 最少需要的钱币个数。如果凑钱失败，输出“Impossible”。
 * 你可以假设，每种待凑钱币的数量是无限多的。
 * <p>
 * 【样例输入】
 * <p>
 * 15
 * 6 2 5 10 20 50 100
 * 1
 * 1 2
 * 0
 * <p>
 * 【样例输出】
 * <p>
 * 2
 * Impossible
 */
public class Test3 {
    private static final boolean commit = true;

    //递归,自顶向下,导致超时
    public static int findMinCoins_Recursion(int desCoin, int[] coin) {
        if (desCoin == 0)
            return 0;
        if (desCoin < 0)
            return -1;
        int minCoinNum = Integer.MAX_VALUE;
        for (int i = 0; i < coin.length; i++) {
            int tmp = findMinCoins_Recursion(desCoin - coin[i], coin);
            if (tmp != -1) {
                if (tmp + 1 < minCoinNum)
                    minCoinNum = tmp + 1;
            }
        }
        return minCoinNum == Integer.MAX_VALUE ? -1 : minCoinNum;
    }

    //递归，备忘录
    public static int findMinCoins_Memo(int desCoin, int[] coin) {
        int[] Memo = new int[desCoin + 1];
        for (int i = 0; i <= desCoin; i++) {
            Memo[i] = -1;
        }
        return findMinCoins_Memo(desCoin, coin, Memo);
    }

    public static int findMinCoins_Memo(int desCoin, int[] coin, int[] Memo) {
        if (desCoin == 0)
            return 0;
        if (desCoin < 0)
            return -1;
        int minCoinNum = Integer.MAX_VALUE;
        for (int i = 0; i < coin.length; i++) {
            int tmp;
            if (desCoin - coin[i] >= 0 && Memo[desCoin - coin[i]] != -1) {
                tmp = Memo[desCoin - coin[i]];
            } else {
                tmp = findMinCoins_Recursion(desCoin - coin[i], coin);
            }
            if (tmp != -1) {
                if (tmp + 1 < minCoinNum)
                    minCoinNum = tmp + 1;
            }
        }
        if (minCoinNum != Integer.MAX_VALUE) {
            Memo[desCoin] = minCoinNum;
            return minCoinNum;
        } else {
            return -1;
        }
    }

    //自底向上
    public static int findMinCoins_DP(int desCoin, int[] coin) {
        int[] minNum = new int[desCoin + 1];
        // 对应硬币只需一个
        for (int i = 0; i < coin.length; i++) {
            if (coin[i] <= desCoin) {
                minNum[coin[i]] = 1;
            }
        }
        for (int i = 1; i <= desCoin; i++) {
            //已经最小硬币
            if (minNum[i] != 0) {
                continue;
            }
            for (int j = 0; j < coin.length; j++) {
                //筛选小于目标硬币值的硬币
                if (coin[j] < i && minNum[i - coin[j]] != 0) {
                    //存在则替换
                    if (minNum[i] == 0)
                        minNum[i] = minNum[i - coin[j]] + 1;
                    //小于则替换
                    if (minNum[i - coin[j]] + 1 < minNum[i])
                        minNum[i] = minNum[i - coin[j]] + 1;
                }
            }
        }
        if (minNum[desCoin] == 0) {
            return -1;
        } else {
            return minNum[desCoin];
        }
    }

    //程序入口
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
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
        while (scanner.hasNext()) {
            //目标硬币
            int desCoin = scanner.nextInt();
            if (desCoin == 0) {
                break;
            }
            //硬币数量
            int coinNum = scanner.nextInt();
            int[] coin = new int[coinNum];
            for (int i = 0; i < coinNum; i++) {
                coin[i] = scanner.nextInt();
            }
            //处理
            int minCoinNum = findMinCoins_DP(desCoin, coin);
            if (minCoinNum == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(String.valueOf(minCoinNum));
            }
        }
//        System.out.println("elapse:" + (System.currentTimeMillis() - start));
    }
}
