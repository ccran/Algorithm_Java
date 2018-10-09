package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】蛇形矩阵是由 1 开始的自然数依次排列成的一个矩阵上三角形
 * <p>
 * 【输入形式】 正整数 N表示层数，N 不大于 100
 * <p>
 * 【输出形式】输出一个 N 行的蛇形矩阵，矩阵三角中同一行的数字用一个空格分开，行尾不要多余的空格。
 * <p>
 * 【样例输入】
 * <p>
 * 5
 * <p>
 * 【样例输出】
 * <p>
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 */
public class Test14 {
    private static final boolean commit = true;

    public static int[][] getSnakeMatrix(int N) {
        int[][] snakeMatrix = new int[N][N];
        int cnt = 1, row = 0, col = 0;
        snakeMatrix[0][0] = cnt;
        while (true) {
            //向下走一步
            if (col == 0) {
                if (row + 1 < N)
                    snakeMatrix[++row][col] = ++cnt;
                else
                    break;
            }
            //往上走
            while (row > 0) {
                snakeMatrix[--row][++col] = ++cnt;
            }
            //复位到第0列
            row = col;
            col = 0;
        }
        return snakeMatrix;
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
        //蛇形矩阵行数正整数
        int N = scanner.nextInt();
        int[][] snakeMatrix = getSnakeMatrix(N);
        for (int i = 0; i < snakeMatrix.length; i++) {
            //每一行
            for (int j = 0; j < snakeMatrix[0].length; j++) {
                if (snakeMatrix[i][j] != 0) {
                    if (j == 0)
                        System.out.print(snakeMatrix[i][j]);
                    else
                        System.out.print(" " + snakeMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
