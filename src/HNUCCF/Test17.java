package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 给定一个数塔，如下图所示。在此数塔中，从顶部出发，在每一节点可以选择走左下或右下，一直走到底层。请找出一条路径，使路径上的数值和最大。
 * 【输入形式】
 * <p>
 * 输入时第一行一个整数n，表示该数塔的行数，其余n行表示该塔每行的数值
 * <p>
 * 【输出形式】
 * <p>
 * 输出包含两行，第一行为最大路径上的数值之和， 第二行n个数字为从上而下最大路径数值
 * <p>
 * 【样例输入】
 * <p>
 * 5
 * 9
 * 12 15
 * 10 6 8
 * 2 18 9 5
 * 19 7 10 4 16
 * 【样例输出】
 * <p>
 * 59
 * 9 12 10 18 10
 */
public class Test17 {
    private static final boolean commit = true;
    //最大值以及路径
    private static int max = Integer.MIN_VALUE;
    private static List<Integer> path = new ArrayList<>();

    public static int[][] getCopyOfNumTower(int[][] numTower) {
        int length = numTower.length;
        int[][] copyOfNumTower = new int[length][];
        for (int i = 0; i < copyOfNumTower.length; i++) {
            int subLength = numTower[i].length;
            copyOfNumTower[i] = new int[subLength];
            for (int j = 0; j < subLength; j++) {
                copyOfNumTower[i][j] = numTower[i][j];
            }
        }
        return copyOfNumTower;
    }

    //计算最大值以及相对应的路径
    public static void getMaxPathValue(int[][] numTower) {
        int length = numTower.length;
        if (length == 1) {
            max = numTower[0][0];
            path.add(numTower[0][0]);
            return;
        }
        //路径记录
        int[][] pathRecord = new int[length][length];
        //数塔复制
        int[][] copyOfNumTower = getCopyOfNumTower(numTower);
        //从倒数第二排开始计算
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //判断取下方左边的元素还是右边的元素
                if (copyOfNumTower[i + 1][j] > copyOfNumTower[i + 1][j + 1]) {
                    //累加比较大的值
                    copyOfNumTower[i][j] += copyOfNumTower[i + 1][j];
                    //记录路径
                    pathRecord[i][j] = j;
                } else {
                    copyOfNumTower[i][j] += copyOfNumTower[i + 1][j + 1];
                    pathRecord[i][j] = j + 1;
                }
            }
        }
        //最大值为0,0
        max = copyOfNumTower[0][0];
        //获取路径
        for (int i = 0, j = 0; i < length; i++) {
            path.add(numTower[i][j]);
            j = pathRecord[i][j];
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
        int n = scanner.nextInt();
        int[][] numTower = new int[n][];
        for (int i = 0; i < n; i++) {
            numTower[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                numTower[i][j] = scanner.nextInt();
            }
        }
        //计算最大路径
        getMaxPathValue(numTower);
        System.out.println(max);
        for (int i = 0; i < path.size(); i++) {
            if (i == 0) {
                System.out.print(path.get(i));
            } else {
                System.out.print(" " + path.get(i));
            }
        }
        System.out.println();
    }
}
