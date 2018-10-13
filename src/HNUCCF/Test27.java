package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 大家应该都会玩“锤子剪刀布”的游戏。现给出两人的交锋记录，请统计双方的胜、平、负次数，
 * 并且给出双方分别出什么手势的胜算最大。
 * <p>
 * 【输入形式】
 * <p>
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，
 * 即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 * <p>
 * 【输出形式】
 * <p>
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，
 * 分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯一，则输出按字母序最小的解。
 * <p>
 * 【样例输入】
 * <p>
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 * 【样例输出】
 * <p>
 * 5 3 2
 * 2 3 5
 * B B
 */
public class Test27 {
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
        //甲胜平负次数
        int[] jia = new int[3];
        //甲B、C、J赢的次数
        int[] winJia = new int[3];
        int[] winYi = new int[3];
        //交锋次数
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            String p1 = scanner.next();
            String p2 = scanner.next();
            //平
            if (p1.equals(p2)) {
                jia[1]++;
            }
            //甲布乙锤，甲布赢
            else if (p1.equals("B") && p2.equals("C")) {
                jia[0]++;
                winJia[0]++;
            } else if (p1.equals("C") && p2.equals("B")) {
                jia[2]++;
                winYi[0]++;
            } else if (p1.equals("B") && p2.equals("J")) {
                jia[2]++;
                winYi[2]++;
            } else if (p1.equals("J") && p2.equals("B")) {
                jia[0]++;
                winJia[2]++;
            } else if (p1.equals("C") && p2.equals("J")) {
                jia[0]++;
                winJia[1]++;
            } else if (p1.equals("J") && p2.equals("C")) {
                jia[2]++;
                winYi[1]++;
            }
        }
        //甲乙赢最多手势
        int maxJia = winJia[0], maxYi = winYi[0];
        int indexJia = 0, indexYi = 0;
        for (int i = 1; i < 3; i++) {
            if (winJia[i] > maxJia) {
                maxJia = winJia[i];
                indexJia = i;
            }
            if (winYi[i] > maxYi) {
                maxYi = winYi[i];
                indexYi = i;
            }
        }
        System.out.println(String.format("%d %d %d", jia[0], jia[1], jia[2]));
        System.out.println(String.format("%d %d %d", jia[2], jia[1], jia[0]));
        switch (indexJia){
            case 0:
                System.out.print("B");
                break;
            case 1:
                System.out.print("C");
                break;
            case 2:
                System.out.print("J");
                break;
        }
        switch (indexYi){
            case 0:
                System.out.println(" B");
                break;
            case 1:
                System.out.println(" C");
                break;
            case 2:
                System.out.println(" J");
                break;
        }
    }
}
