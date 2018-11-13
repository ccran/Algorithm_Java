package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * 
 * 对于一个正整数n，如果是偶数，就把n砍掉一半；如果是奇数，把n变成 3*n+ 1后砍掉一半，直到该数变为1为止。
 * 请计算需要经过几步才能将n变到1，具体可见样例。
 * 
 * 【输入形式】
 * 
 * 测试包含多个用例，每个用例包含一个整数n,当n为0 时表示输入结束。（1<=n<=10000）
 * 
 * 【输出形式】
 * 
 * 对于每组测试用例请输出一个数，表示需要经过的步数,每组输出占一行。
 * 
 * 【样例输入】
 * 
 * 3 2 0 【样例输出】
 * 
 * 5 1
 */
public class Test47 {
	private static final boolean commit = true;

	// 程序入口
	public static void main(String[] args) {
		InputStream inputStream = null;
		// 从文件流读取输入
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
		// 循环获取输入
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int cnt = 0;
			while (n != 1) {
				// 奇数
				if (n % 2 != 0) {
					n = n * 3 + 1;
				}
				n /= 2;
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
