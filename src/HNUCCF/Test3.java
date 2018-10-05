package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

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
