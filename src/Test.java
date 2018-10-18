import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static void main(String[] args) throws Exception {
        print("192.168.1.11", 9100, "123456", "123456", 3);
    }

    private static void print(String ip, int port, String str, String code, int skip)
            throws Exception {
        Socket client = new java.net.Socket();
        PrintWriter socketWriter;
        client.connect(new InetSocketAddress(ip, port), 10000); // 创建一个 socket
        socketWriter = new PrintWriter(client.getOutputStream());// 创建输入输出数据流
        //初始化
        socketWriter.write(0x1b);
        socketWriter.write(0x40);
        /* 纵向放大一倍 */
        socketWriter.write(0x1c);
        socketWriter.write(0x21);
        socketWriter.write(8);
        socketWriter.write(0x1b);
        socketWriter.write(0x21);
        socketWriter.write(8);
        socketWriter.println(str.getBytes("GB2312"));
        // 打印条形码
        socketWriter.write(0x1d);
        socketWriter.write(0x68);
        socketWriter.write(120);
        socketWriter.write(0x1d);
        socketWriter.write(0x48);
        socketWriter.write(0x01);
        socketWriter.write(0x1d);
        socketWriter.write(0x6B);
        socketWriter.write(0x02);
        socketWriter.println(code.getBytes("GB2312"));
        socketWriter.write(0x00);
        //打印
        socketWriter.write(0x0D);
        for (int i = 0; i < skip; i++) {
            socketWriter.println(" ");// 打印完毕自动走纸
        }
        socketWriter.flush();
        socketWriter.close();
        client.close();
    }
}
