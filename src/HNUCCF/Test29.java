package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】在足球比赛中，有不少赛事，例如世界杯淘汰赛和欧洲冠军联赛淘汰赛中，
 * 当比赛双方经过正规比赛和加时赛之后仍然不分胜负时，需要进行点球大战来决定谁能够获得最终的胜利。
 * 点球大战的规则非常简单，两方轮流派出球员罚点球，每方各罚5个。当5轮点球结束以后如果仍然不分胜负，
 * 则进入一轮定胜负的阶段。两方各派一名球员罚点球，直到有一方罚进而另一方没有进为止。
 * 在北美职业冰球联赛中，也有点球大战。与足球的规则不同的是，它只先罚3轮点球，
 * 随后就进入一轮定胜负的阶段，而其他的规则完全一样。
 * 在本题中，输入将给出每次点球是否罚进，而你的任务则是输出一个“比分板”。
 * <p>
 * 【输入形式】输入包含多组数据。每组数据的第一行包含一个整数N(1<=N<=18)，
 * 表示双方总共罚了多少个点球，N=0表示输入结束。随后有N行，每行是一个如下形式的字符串：
 * XXXX good：表示这个点球罚进
 * 或者XXXX no good：表示这个点球没有罚进
 * 其中XXXX表示球员名字（全部由字母和空格组成，保证不会出现歧义）
 * 每一行保证不超过100个字符。
 * XXXX和good以及XXXX和no、no和good之间保证有且只有1个空格。
 * good、no good都是小写。本题是大小写相关的。
 * 数据不保证点球大战一定结束，也不保证在结束以后立即结束这组数据（即：不用判断点球大战是否结束，
 * 只用把罚进的点球往比分上加即可）。
 * <p>
 * 【输出形式】对每组数据，输出一个比分板。一个点球如果罚进，则在对应的地方标上’O’，
 * 如果没有进则标上’X’。先罚球的队伍的信息在上面，后罚的在下面。最右边标上两队的比分。
 * 具体格式参考样例输出。注意如果一轮点球只罚了一个，则后面那个点球对应的地方写上’-’。
 * <p>
 * 【样例输入】
 * <p>
 * 6
 * Riise good
 * Ballack good
 * Gerrard no good
 * Lampard no good
 * Fernando Torres good
 * Malouda good
 * 9
 * Christiano Ronaldo no good
 * Messi no good
 * Giggs good
 * Abidal no good
 * Carrick good
 * Ronaldinho good
 * Rooney good
 * Henry no good
 * Tevez good
 * 0
 * <p>
 * 【样例输出】
 * <p>
 * 1 2 3 Score
 * O X O 2
 * O X O 2
 * 1 2 3 4 5 Score
 * X O O O O 4
 * X X O X - 1
 */
public class Test29 {
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
        while (true) {
            int N = scanner.nextInt();
            if (N == 0)
                break;
            scanner.nextLine();
            //总射门次数是否偶数
            boolean sumShootTimesEven = (N % 2 == 0);
            //每队射门次数
            int shootTimes = sumShootTimesEven ? N / 2 : (N + 1) / 2;
            //a b队的计分板
            int[] teamA = new int[shootTimes];
            int[] teamB = new int[shootTimes];
            for (int i = 0; i < shootTimes; i++) {
                String teamAShootStr = scanner.nextLine();
                teamA[i] = getScore(teamAShootStr);
                //偶数则第二队最后一次有射门
                if (i != shootTimes - 1 || (i == shootTimes - 1 && sumShootTimesEven)) {
                    String teamBShootStr = scanner.nextLine();
                    teamB[i] = getScore(teamBShootStr);
                }
            }
            //输出结果
            printScoreHeader(shootTimes);
            printScore(teamA);
            printScore(teamB);
        }
    }

    //根据串返回1（得分）或-1（没得分）
    public static int getScore(String shootStr) {
        //加空格判断防止出现类似"Bobno good"这样的用例
        return shootStr.contains(" no good") ? -1 : 1;
    }

    //输出计分板
    public static void printScoreHeader(int shootTimes) {
        for (int i = 1; i <= shootTimes; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Score");
    }

    //输出一个队伍成绩
    public static void printScore(int[] team) {
        int winCnt = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] == 1) {
                System.out.print("O ");
                winCnt++;
            } else if (team[i] == -1) {
                System.out.print("X ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println(winCnt);
    }
}
