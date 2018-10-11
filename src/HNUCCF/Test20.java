package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 国王为他的忠诚的骑士支付金币。在他服役的第一天，骑士收到一枚金币。
 * 在接下来2天（第二天和第三天的服务），骑士每天收到2金币。
 * 在未来三天（第五，第四，和第六天的服务），骑士每天收到三金币。
 * 在未来四天（第七，第八，第九，和第十天的服务），骑士每天收到四金币。
 * 这一模式的付款方式将继续下去：在接下来的n天骑士每天将收到n枚金币，
 * 而在接接下来的n+1天每天将收到n+1枚金币，这里n是正整数。
 * 你的程序将确定在任何给定的天数（从第1天开始）支付给骑士的金币总数。
 * <p>
 * 【输入形式】
 * <p>
 * 输入包含至少一行，但不超过21行。输入的每一行包含一个测试案例的数据，
 * 即一个整数（1~10000），代表天数。
 * <p>
 * 【输出形式】
 * <p>
 * 每一行输出对应一个测试用例，由天数和支付给骑士的金币总数量组成，中间用空格分隔。
 * <p>
 * 【样例输入】
 * <p>
 * 10
 * 6
 * 10000
 * 1000
 * 21
 * 22
 * 【样例输出】
 * <p>
 * 10 30
 * 6 14
 * 10000 942820
 * 1000 29820
 * 21 91
 * 22 98
 */
public class Test20 {
    private static final boolean commit = true;
    private static int[] coin;
    private static final int MAX_DAY = 10001;

    //提前算出所有金币量
    public static void initCoin() {
        coin = new int[MAX_DAY];
        int sum = 1, startCoin = 1, cnt = 0;
        for (int i = 1; i < MAX_DAY; i++) {
            coin[i] = sum;
            if (cnt == 0) {
                startCoin++;
                cnt = startCoin;
            }
            sum += startCoin;
            cnt--;
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
        initCoin();
        Scanner scanner = new Scanner(inputStream);
        //循环获取输入
        while (scanner.hasNext()) {
            int day = scanner.nextInt();
            System.out.println(day + " " + coin[day]);
        }
    }
}
