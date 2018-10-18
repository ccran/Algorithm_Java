package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 【问题描述】
 * <p>
 * 2018年俄罗斯世界杯结束了，法国获得冠军，全世界球迷度过了一个非常愉快的夏天。作为中国球迷，不能总是看别人踢球，
 * 这不福利来了，根据FIFA（国际足联）及全体成员协会的一致决定，2118年世界杯将在中国举办，作为东道主，
 * 中国队将无需参加预选赛而直接参加决赛阶段的比赛。
 * <p>
 * 比赛规则如下：
 * <p>
 * 总共n（n为偶数）个球队参加比赛
 * <p>
 * 按照分组赛积分排名，前n/2的球队进入淘汰赛
 * <p>
 * 积分排名的规则如下：球队获胜得3分，平局得1分，失利得0分，按照积分递减、净胜球递减以及进球数递减方式排名
 * <p>
 * 编写一个程序，根据给出的参赛队伍名单和所有比赛的结果，找出成功进入淘汰赛阶段的球队名单。
 * <p>
 * 【输入形式】
 * <p>
 * 第一行输入包含唯一整数n(1<=n<=50)，参加世界杯决赛的球队数量。接下来的n行是各球队的名字，
 * 为长度不超过30个字符的英文字符。接下来的n*(n-1)/2行，每行格式name1-name2 num1:num2（0<=num1, num2<=100），表示对阵球队及比分.
 * <p>
 * 【输出形式】
 * <p>
 * 输入n/2行，表示进入淘汰赛阶段的球队，按照字典序进行排列，每个球队名字占一行。
 * 【样例输入】
 * <p>
 * 4
 * A
 * B
 * C
 * D
 * A-B 1:1
 * A-C 2:2
 * A-D 1:0
 * B-C 1:0
 * B-D 0:3
 * C-D 0:3
 * <p>
 * 【样例输出】
 * <p>
 * A
 * D
 */
public class Test35 {
    private static final boolean commit = true;

    //得分
    public static class Score {
        //积分
        int grade;
        //净胜球
        int win;
        //进球数
        int enter;
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
        //输入队伍
        Map<String, Score> teamScoreMap = new HashMap<>();
        int teamNum = scanner.nextInt();
        for (int i = 0; i < teamNum; i++) {
            teamScoreMap.put(scanner.next(), new Score());
        }
        scanner.nextLine();
        //输入比赛
        int matchNum = teamNum * (teamNum - 1) / 2;
        for (int i = 0; i < matchNum; i++) {
            String line = scanner.nextLine();
            String[] match = line.split(" |-|:");
            int score1 = Integer.parseInt(match[2]), score2 = Integer.parseInt(match[3]);
            //队伍1比分
            Score team1Score = teamScoreMap.get(match[0]);
            //队伍2比分
            Score team2Score = teamScoreMap.get(match[1]);
            //队伍2获胜
            if (score1 < score2) {
                //队伍1设置
                team1Score.enter += score1;
                //队伍2设置
                team2Score.grade += 3;
                team2Score.win += (score2 - score1);
                team2Score.enter += score2;
            } else if (score1 > score2) {
                //队伍1设置
                team1Score.grade += 3;
                team1Score.win += (score1 - score2);
                team1Score.enter += score1;
                //队伍2设置
                team2Score.enter += score2;
            } else {
                //队伍1设置
                team1Score.grade += 1;
                team1Score.enter += score1;
                //队伍2设置
                team2Score.grade += 1;
                team2Score.enter += score2;
            }
            teamScoreMap.put(match[0], team1Score);
            teamScoreMap.put(match[1], team2Score);
        }
        //获取前n/2名
        List<Map.Entry<String, Score>> teamList = new ArrayList<>(teamScoreMap.entrySet());
        Collections.sort(teamList, new Comparator<Map.Entry<String, Score>>() {
            @Override
            public int compare(Map.Entry<String, Score> o1, Map.Entry<String, Score> o2) {
                Score score1 = o1.getValue(), score2 = o2.getValue();
                if (score1.grade == score2.grade) {
                    if (score1.win == score2.win) {
                        return score2.enter - score1.enter;
                    } else {
                        return score2.win - score1.win;
                    }
                } else {
                    return score2.grade - score1.grade;
                }
            }
        });
        teamList = teamList.subList(0, teamList.size() / 2);
        Collections.sort(teamList, new Comparator<Map.Entry<String, Score>>() {
            @Override
            public int compare(Map.Entry<String, Score> o1, Map.Entry<String, Score> o2) {
                return o1.getKey().compareTo(o2.toString());
            }
        });
        //输出结果
        for (Map.Entry<String, Score> team : teamList) {
            System.out.println(team.getKey());
        }
    }
}
