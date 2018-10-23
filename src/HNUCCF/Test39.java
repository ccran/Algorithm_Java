package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 循环数是n位长度的整数，当乘以从1到n的任何整数时，产生原始数字的“循环”。也就是说，
 * 如果考虑最后一个数字之后的数字“绕”回到第一个数字，两个数字中的数字序列将是相同的，
 * 尽管它们可能从不同的位置开始。例如，数字142857是循环的，如下表所示：
 * <p>
 * 142857	*1	=	142857
 * 142857	*2	=	285714
 * 142857	*3	=	428571
 * 142857	*4	=	571428
 * 142857	*5	=	714285
 * 142857	*6	=	857142
 * <p>
 * 编写一个程序来确定数字是否是循环数。
 * <p>
 * 【输入形式】
 * <p>
 * 输入一个数，长度在2到60位之间(请注意，前面的零不应该被删除，它们被认为是确定n的大小和计数的一部分，
 * 因此，“01”是一个两位数的数字，与“1”是一个一位数的数字不同。) 。
 * <p>
 * 【输出形式】
 * <p>
 * 对于每个输入，输出一行(Yes或No)标识它是否是循环数。
 * <p>
 * 【样例输入】
 * <p>
 * 142857
 * 【样例输出】
 * <p>
 * Yes
 */
public class Test39 {
    private static final boolean commit = true;

    //计算依次乘以长度以后所得到的新字符串
    public static boolean isRecycle(String inputStr) {
        int length = inputStr.length();
        boolean isRecycle = true;
        //循环乘以i
        for (int i = 1; i <= length; i++) {
            //进位
            int carry = 0;
            //每轮循环新的结果
            String newInputStr = "";
            for (int j = length - 1; j >= 0; j--) {
                //每位相乘
                char ch = inputStr.charAt(j);
                int res = (ch - '0') * i + carry;
                //计算进位
                carry = res / 10;
                //计算剩余
                newInputStr = String.valueOf(res % 10) + newInputStr;
            }
            //最后一个进位
            if (carry > 0) {
                newInputStr = String.valueOf(carry) + newInputStr;
            }
            //补0
            while (newInputStr.length() < inputStr.length()) {
                newInputStr = "0" + newInputStr;
            }
            //长度不同直接退出
            if (newInputStr.length() != inputStr.length()) {
                isRecycle = false;
                break;
            }
            //比较是否循环相等
            int startIndex = newInputStr.indexOf(inputStr.charAt(0));
            if (startIndex == -1) {
                isRecycle = false;
                break;
            }
            for (int m = 0; m < inputStr.length(); m++) {
                if (inputStr.charAt(m) != newInputStr.charAt(startIndex++)) {
                    isRecycle = false;
                    break;
                }
                if (startIndex >= newInputStr.length()) {
                    startIndex = 0;
                }
            }
        }
        return isRecycle;
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
        //输入数字
        String inputStr = scanner.next();
        if(isRecycle(inputStr)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
