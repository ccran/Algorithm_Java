package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 古希腊数学家毕达哥拉斯在自然数研究中发现，220 的所有真约数(即不是自身的约数)之和为：
 * <p>
 * 1+2+4+5+10+11+20+22+44+55+110＝284。
 * 而 284 的所有真约数为 1、2、4、71、 142，加起来恰好为 220。
 * 人们对这样的数感到很惊奇，并称之为亲和数。一般地讲，
 * 如果两个数中任何一个数都是另一个数的真约数之和，则这两个数就是亲和数。
 * 你的任务就编写一个程序，判断给定的两个数是否是亲和数。
 * <p>
 * 【输入形式】
 * <p>
 * 输入若干行数据（大于0），每行一个实例,包含两个整数A,B； 其中 0 <= A,B <= 600000 ;
 * <p>
 * 【输出形式】
 * <p>
 * 对于每个测试实例，如果 A 和 B 是亲和数的话输出 YES，否则输出 NO
 * <p>
 * 【样例输入】
 * <p>
 * 220 284
 * 100 200
 * 【样例输出】
 * <p>
 * YES
 * NO
 */
public class Test21 {
    private static final boolean commit = true;

    public static int getRealDivisorSum(int num) {
        if (num == 0 || num == 1)
            return 0;
        int sum = 1;
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                sum += i;
                int other = num / i;
                if (other != i) {
                    sum += other;
                }
            }
        }
        return sum;
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
        while (scanner.hasNext()) {
            int opeA = scanner.nextInt();
            int opeB = scanner.nextInt();
            if(getRealDivisorSum(opeA)==opeB
                    && getRealDivisorSum(opeB)==opeA){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
