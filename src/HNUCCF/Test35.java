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
        Map<String, Integer> teamScoreMap = new HashMap<>();
        int teamNum = scanner.nextInt();
        for (int i = 0; i < teamNum; i++) {
            teamScoreMap.put(scanner.next(), 0);
        }
        scanner.nextLine();
        //输入比赛
        int matchNum = teamNum * (teamNum - 1) / 2;
        for (int i = 0; i < matchNum; i++) {
            String line = scanner.nextLine();
            String[] match = line.split(" |-|:");
            int score1 = Integer.parseInt(match[2]), score2 = Integer.parseInt(match[3]);
            if (score1 < score2) {
                teamScoreMap.put(match[1], teamScoreMap.get(match[1]) + 3);
            } else if (score1 > score2) {
                teamScoreMap.put(match[0], teamScoreMap.get(match[0]) + 3);
            } else {
                teamScoreMap.put(match[0], teamScoreMap.get(match[0]) + 1);
                teamScoreMap.put(match[1], teamScoreMap.get(match[1]) + 1);
            }
        }
        //获取前n/2名
        List<Map.Entry<String, Integer>> teamList = new ArrayList<>(teamScoreMap.entrySet());
        Collections.sort(teamList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        teamList = teamList.subList(0, teamList.size() / 2);
        Collections.sort(teamList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.toString());
            }
        });
        for(Map.Entry<String, Integer> team:teamList){
            System.out.println(team.getKey());
        }
    }
}
