package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 大家当年一定都下过飞行棋吧。现在Lele和Yueyue要下的棋和这个很相似，只是更简单一点而已。
 * <p>
 * 棋盘由N个格子组成，分别标记为第0格到第N-1格。格子分为两种，一种是普通格子，即表示在该格可以停留。
 * 否则是特殊的格子，一旦走到上面，就要根据上面标记的数飞到相应的格子上。如果飞到一个特殊的格子上，则可以继续飞。
 * <p>
 * 除了第0格外，其他格子都只能容纳一个玩家。即一旦A玩家已经在某个格子上，B玩家又走到这里，A玩家则会被踢回第0格，而B玩家留在这个格子上面。
 * <p>
 * 第N-1个格子是终点，一旦一个玩家走到这个格子上，该玩家获胜，游戏结束。
 * <p>
 * 刚刚开始时，两个玩家都站在第0格上，依次扔骰子，根据骰子显示的点数走相应的格子数。比如，玩家在第0格，扔出了5点，
 * 则会走到第5个格子上。如果玩家走得超出了棋盘的范围，则要往回走一定的步数。比如，棋盘一共有7(0~6)个格子,玩家在第4格上，扔出了6点，
 * 最终他会走到第2格上(4->5->6->5->4->3->2)。
 * <p>
 * 根据观察，骰子扔出来的数也是有规律的。
 * 对于每一盘棋，扔出的第一个点数为 F0=(A*C+B)%6+1,第二个点数为 F1=(A*F0+B)%6+1,
 * 第三个点数为 F2=(A*F1+B)%6+1 ....依此类推。
 * <p>
 * 每一盘棋都是由Lele先走，现在就请你当裁判，看谁能获胜。
 * <p>
 * 【输入形式】
 * <p>
 * 本题目包含多组测试，请处理到文件结束。
 * 每组数据占两行。
 * 第一行有4个整数N,A,B,C(含义见题目描述，6<N<200,0<=A,B,C<=2^31)。
 * 第二行有N个字符串，分别表示棋盘上第0个到第N-1个格子的内容。两个字符串之间用一个空格分隔开。
 * <p>
 * 如果字符串为"N",则表示这个格子为普通格子。否则字符串为"GX"(X为0到N-1之间的整数)的形式，
 * 其中X表示玩家走到这个格子时，要马上飞到第X个格子。
 * 数据保证第0个和第N-1个格子一定为"N"。
 * <p>
 * 【输出形式】
 * <p>
 * 对于每组数据，在一行内输出结果。
 * 如果Lele能赢这盘棋，则输出"Lele",如果Yueyue赢的话，就输出"Yueyue"。
 * <p>
 * 【样例输入】
 * <p>
 * 7 1 0 6
 * N G3 N N N N N
 * 7 1 0 6
 * N G4 N N N N N
 * 【样例输出】
 * <p>
 * Lele
 * Yueyue
 */
public class Test31 {
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
        //循环获取输入
        while (scanner.hasNext()) {
            //输入参数以及飞行棋
            int N = scanner.nextInt(), A = scanner.nextInt(), B = scanner.nextInt(), C = scanner.nextInt();
            String[] flyChess = new String[N];
            for (int i = 0; i < N; i++) {
                flyChess[i] = scanner.next();
            }
            //标志玩家位置
            int LeleLocate = 0, YueyueLocate = 0;
            //接下来走的步数，以及标志谁移动
            int step = C;
            boolean LeleMove = true;
            //一方没停都不停
            while (true) {
                step = (A * step + B) % 6 + 1;
                //Lele溜
                if (LeleMove) {
                    LeleLocate += step;
                    //超过往回走
                    if (LeleLocate > N - 1) {
                        LeleLocate = N - 1 - (LeleLocate - (N - 1));
                    }
                    //是否是特殊格子
                    while (flyChess[LeleLocate].contains("G")) {
                        LeleLocate = Integer.parseInt(flyChess[LeleLocate].substring(1));
                    }
                    //另一方是否停在格子上
                    if (LeleLocate == YueyueLocate) {
                        YueyueLocate = 0;
                    }
                    //到终点结束游戏
                    if (LeleLocate == N - 1) {
                        break;
                    }
                    LeleMove = false;
                }
                //Yueyue溜
                else {
                    YueyueLocate += step;
                    //超过往回走
                    if (YueyueLocate > N - 1) {
                        YueyueLocate = N - 1 - (YueyueLocate - (N - 1));
                    }
                    //是否是特殊格子
                    while (flyChess[YueyueLocate].contains("G")) {
                        YueyueLocate = Integer.parseInt(flyChess[YueyueLocate].substring(1));
                    }
                    //另一方是否停在格子上
                    if (LeleLocate == YueyueLocate) {
                        LeleLocate = 0;
                    }
                    //到终点结束游戏
                    if (YueyueLocate == N - 1) {
                        break;
                    }
                    LeleMove = true;
                }
            }
            //输出结果
            if (LeleLocate == N - 1) {
                System.out.println("Lele");
            } else {
                System.out.println("Yueyue");
            }
        }
    }
}
