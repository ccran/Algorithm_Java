package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * 【问题描述】
 * <p>
 * 标准的Web浏览器具有在最近访问的页面中前后移动的特性。实现这些特性的一种方法是使用两个堆栈来跟踪可以通过前后移动到达的页面。
 * 在这个问题中，我们要求实现这一点。
 * <p>
 * 需要支持以下命令：
 * <p>
 * BACK：将当前页面压入前向堆栈的顶部；从后向堆栈的顶部弹出该页，使其成为新的当前页。如果后向堆栈为空，则该指令忽略。
 * <p>
 * FORWARD：将当前页面压入后向堆栈的顶部；从前向堆栈的顶部弹出该页，使其成为新的当前页。如果前向堆栈为空，则该指令忽略。
 * <p>
 * VISIT：将当前页面压入后向堆栈的顶部，将URL指定为新的当前页。前向堆栈被清空。
 * <p>
 * QUIT：退出浏览器。
 * <p>
 * 假设浏览器最初在网址http://www.game.org/上加载网页。
 * <p>
 * <p>
 * 【输入形式】输入是一个命令序列。命令关键字BACK、FORWARD、VISIT和QUIT都是大写。URL中无空格，最多有70个字符。
 * 假定在任何时候，每个堆栈中没有问题实例需要超过100个元素。输入的结尾由QUIT命令标识。
 * <p>
 * 【输出形式】除QUIT外的每个命令，如果命令没有被忽略，则在命令执行后输出当前页面的URL，否则，打印"Ignored"。
 * 每个命令的输出独立打印一行。QUIT命令无输出。
 * <p>
 * 【样例输入】
 * <p>
 * VISIT http://game.ashland.edu/
 * VISIT http://game.baylor.edu/acmicpc/
 * BACK
 * BACK
 * BACK
 * FORWARD
 * VISIT http://www.our.com/
 * BACK
 * BACK
 * FORWARD
 * FORWARD
 * FORWARD
 * QUIT
 * <p>
 * 【样例输出】
 * <p>
 * http://game.ashland.edu/
 * <p>
 * http://game.baylor.edu/acmicpc/
 * <p>
 * http://game.ashland.edu/
 * <p>
 * http://www.game.org/
 * <p>
 * Ignored
 * <p>
 * http://game.ashland.edu/
 * <p>
 * http://www.our.com/
 * <p>
 * http://game.ashland.edu/
 * <p>
 * http://www.game.org/
 * <p>
 * http://game.ashland.edu/
 * <p>
 * http://www.our.com/
 * <p>
 * Ignored
 */
public class Test33 {
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
        //后向栈、前向栈、当前页面
        Stack<String> back = new Stack<>(), forward = new Stack<>();
        String present = "http://www.game.org/";
        //循环获取输入
        while (true) {
            String order = scanner.nextLine();
            if (order.equals("QUIT"))
                break;
            //后退
            if ("BACK".equals(order)) {
                if (back.isEmpty()) {
                    System.out.println("Ignored");
                    continue;
                }
                //压入前向栈
                forward.push(present);
                //弹出后向栈
                present = back.pop();
                System.out.println(present);
            }
            //前进
            else if ("FORWARD".equals(order)) {
                if (forward.isEmpty()) {
                    System.out.println("Ignored");
                    continue;
                }
                //压入后向栈
                back.push(present);
                //弹出前向栈
                present = forward.pop();
                System.out.println(present);
            } else {
                String url = order.split(" ")[1];
                //压入后向栈
                back.push(present);
                //指定当前url
                present = url;
                //清空前向栈
                forward.clear();
                //输出结果
                System.out.println(present);
            }
        }
    }
}
