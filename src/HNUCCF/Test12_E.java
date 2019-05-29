package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：
 * “十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。
 * ”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 * <p>
 * 【输入形式】
 * <p>
 * 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。
 * 这里Galleon是[0, 107]区间内的整数，Sickle是[0, 17)区间内的整数，Knut是[0, 29)区间内的整数。
 * <p>
 * 【输出形式】
 * <p>
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 * <p>
 * 【样例输入1】
 * <p>
 * 10.16.27 14.1.28
 * 【样例输出1】
 * <p>
 * 3.2.1
 * 【样例输入2】
 * <p>
 * 14.1.28 10.16.27
 * 【样例输出1】
 * <p>
 * -3.2.1
 */
public class Test12_E {
    private static final boolean commit = true;

    public static class Money {
        public int gallon;
        public int sickle;
        public int knut;

        //计算零钱
        public static Money calcChange(Money p, Money a) {
            //判断是否给了足够的钱
            boolean aSmaller = false;
            if (a.gallon < p.gallon) {
                aSmaller = true;
            } else if (a.gallon == p.gallon) {
                if (a.sickle < p.sickle) {
                    aSmaller = true;
                } else if (a.sickle == p.sickle) {
                    if (a.knut < p.knut) {
                        aSmaller = true;
                    }
                }
            }
            //计算差值
            Money big = a, small = p;
            if (aSmaller) {
                big = p;
                small = a;
            }
            Money change = new Money();
            //knut位
            if (big.knut >= small.knut) {
                change.knut = big.knut - small.knut;
            } else {
                change.knut = 29 - small.knut + big.knut;
                big.sickle--;
                //判断是否需要向gallon位借位
                if (big.sickle < 0) {
                    big.sickle = 16;
                    big.gallon--;
                }
            }
            //sickle位
            if (big.sickle >= small.sickle) {
                change.sickle = big.sickle - small.sickle;
            } else {
                change.sickle = 17 - small.sickle + big.sickle;
                big.gallon--;
            }
            //gallen位
            change.gallon = big.gallon - small.gallon;
            //给的钱不够则为负数
            if (aSmaller) {
                change.gallon = -change.gallon;
            }
            return change;
        }

        //串转换成Money对象
        public static Money strToMoney(String moneyStr) {
            Money money = new Money();
            String[] moneyArr = moneyStr.split("\\.");
            money.gallon = Integer.parseInt(moneyArr[0]);
            money.sickle = Integer.parseInt(moneyArr[1]);
            money.knut = Integer.parseInt(moneyArr[2]);
            return money;
        }

        @Override
        public String toString() {
            return gallon + "." + sickle + "." + knut;
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
        Money p = Money.strToMoney(scanner.next()), a = Money.strToMoney(scanner.next());
        System.out.println(Money.calcChange(p, a));
    }
}
