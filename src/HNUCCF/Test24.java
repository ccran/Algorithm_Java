package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 一个名叫是 PigHeadThree 的研究组织设计了一台实验用的计算机，命名为 PpMm。PpMm只能执行简单的六种命令 A，B，C，D，E，F；只有二个内存 M1，M2；三个寄存器 R1，R2，R3。六种命令的含义如下：
 * 命令 A：将内存 M1 的数据装到寄存器 R1 中；
 * 命令 B：将内存 M2 的数据装到寄存器 R2 中；
 * 命令 C：将寄存器 R3 的数据装到内存 M1 中；
 * 命令 D：将寄存器 R3 的数据装到内存 M2 中；
 * 命令 E：将寄存器 R1 中的数据和寄存器 R2 中的数据相加，结果放到寄存器 R3 中；
 * 命令 F：将寄存器 R1 中的数据和寄存器 R2 中的数据相减，结果放到寄存器 R3 中。
 * 你的任务是：设计一个程序模拟 PpMm 的运行。
 * <p>
 * 【输入形式】
 * <p>
 * 有若干组，每组有 2 行，第一行是 2 个整数，分别表示 M1 和 M2 中的初始内容；
 * 第二行是一串长度不超过 200 的由大写字母 A 到 F 组成的命令串，命令串的含义如上所述。
 * <p>
 * 【输出形式】
 * <p>
 * 对应每一组的输入，输出只有一行，二个整数，分别表示 M1，M2 的内容；其中 M1 和 M2 之间用逗号隔开。
 * <p>
 * 【样例输入】
 * <p>
 * 100 288
 * ABECED
 * 876356 321456
 * ABECAEDBECAF
 * 【样例输出】
 * <p>
 * 388,388
 * 2717080,1519268
 */
public class Test24 {
    private static final boolean commit = true;
    private static int m1, m2;

    //操作解析
    public static void operation(String operationStr) {
        int r1 = 0, r2 = 0, r3 = 0;
        for (int i = 0; i < operationStr.length(); i++) {
            char ch = operationStr.charAt(i);
            switch (ch) {
                case 'A':
                    r1 = m1;
                    break;
                case 'B':
                    r2 = m2;
                    break;
                case 'C':
                    m1 = r3;
                    break;
                case 'D':
                    m2 = r3;
                    break;
                case 'E':
                    r3 = r1 + r2;
                    break;
                case 'F':
                    r3 = r1 - r2;
                    break;
            }
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
        while (scanner.hasNext()) {
            m1 = scanner.nextInt();
            m2 = scanner.nextInt();
            String operationStr = scanner.next();
            operation(operationStr);
            System.out.println(m1 + "," + m2);
        }
    }
}
