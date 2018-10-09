package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 城市公交系统有一个记录仪，用于记录每个站点的乘客人数的变化情况，
 * 例如：x表示到站前公交车上的乘客人数，y表示离站时公交车上的乘客人数，
 * 则该记录仪记录的该站的数字为y-x。
 * <p>
 * 对于一辆公交车和n个车站，a1,a2,...,an为该公交车在各站的记录数据。
 * <p>
 * 假定w为该公交车可容纳的最大乘客人数，编程求出在第一站停靠之前公交车上人数的可能数据有多少种？
 * <p>
 * 【输入形式】
 * <p>
 * 第一行包含两个数据n和w(1<=n<=1000, 1<=w<=109)，分别表示车站的数目和公交车可容纳的最大乘客人数。
 * <p>
 * 第二行包含一个序列a1,a2,...,an，表示记录仪记录的各站的数据。
 * <p>
 * 【输出形式】
 * <p>
 * 输出一个整数，表示公交车在第一站停靠之前可能的乘客人数数据的个数，如果没有，则输出0。
 * <p>
 * 【样例输入1】
 * <p>
 * 3 5
 * 2 1 -3
 * 【样例输出1】
 * <p>
 * 3
 * 【样例输入2】
 * <p>
 * 2 4
 * -1 1
 * 【样例输出2】
 * <p>
 * 4
 * 【样例输入3】
 * <p>
 * 4 10
 * 2 4 1 2
 * 【样例输出3】
 * <p>
 * 2
 * 【样例说明】
 * <p>
 * 在第一个样例中，乘客数可能有0、1、2，共3种情况
 * 在第二个样例中，乘客数可能有1、2、3、4，共4种情况
 * 在第三个样例种，乘客数可能为0或1，共2种情况
 */
public class Test15 {
    private static final boolean commit = true;

    //获取可能乘客数目（暴力遍历，测试数据7,8超时）
    public static int getPossiblePassengers(int[] record, int maxPassenger) {
        int cnt = 0;
        for (int i = 0; i <= maxPassenger; i++) {
            boolean flag = true;
            int sum = i;
            for (int j = 0; j < record.length; j++) {
                sum += record[j];
                if (sum < 0 || sum > maxPassenger) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }

    //计算最大乘客量与最小乘客量进行判断
    public static int getPossiblePassgengers_ac(int[] record, int maxPassenger) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < record.length; i++) {
            sum += record[i];
            if (min > sum) {
                min = sum;
            }
            if (max < sum) {
                max = sum;
            }
        }
        //总乘客不能大于最大值，也不能为负数
        //乘客最小数量
        int start = min < 0 ? -min : 0;
        //乘客最大数量
        int end = max > 0 ? maxPassenger - max : maxPassenger;
        if (start > maxPassenger || end < 0 || end < start) {
            return 0;
        } else {
            return end - start + 1;
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
        //输入车站数目以及公交车可以容纳的数目
        int stationNum = scanner.nextInt();
        int maxPassenger = scanner.nextInt();
        int[] record = new int[stationNum];
        for (int i = 0; i < stationNum; i++) {
            record[i] = scanner.nextInt();
        }
        System.out.println(getPossiblePassgengers_ac(record, maxPassenger));
    }
}
