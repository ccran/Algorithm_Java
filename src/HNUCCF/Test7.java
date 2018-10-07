package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Test7 {
    private static final boolean commit = true;

    //计算名次
    public static int[] calcRank(int[] sumPeople) {
        //对于非默认排序（从小到大排序），需用装箱类+Comparator
        //Arrays.copyOf返回基础类型数组
        int peopleNum = sumPeople.length;
        Integer[] copyOfSumPeople = new Integer[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            copyOfSumPeople[i] = sumPeople[i];
        }
        //从大到小排序
        Arrays.sort(copyOfSumPeople, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //输入名次
        Map<Integer, Integer> rankMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < peopleNum; i++) {
            if (!rankMap.containsKey(copyOfSumPeople[i])) {
                rankMap.put(copyOfSumPeople[i], ++cnt);
            }
        }
        //返回结果
        int[] rank = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            rank[i] = rankMap.get(sumPeople[i]);
        }
        return rank;
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
        //输入决赛人数
        int sumPeopleNum = scanner.nextInt();
        int[] sumPeople = new int[sumPeopleNum];
        for (int i = 0; i < sumPeopleNum; i++) {
            sumPeople[i] = scanner.nextInt();
        }
        //计算排名
        int[] rank = calcRank(sumPeople);
        for (int i = 0; i < rank.length; i++) {
            if (i == 0) {
                System.out.print(rank[i]);
            } else {
                System.out.print(" " + rank[i]);
            }
        }
        System.out.println();
    }
}
