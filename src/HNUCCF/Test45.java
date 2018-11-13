package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * 【问题描述】给定一个可以带通配符问号的正整数W，问号可以代表任意一个一位数字。再给定一个正整数X，和W具有同样的长度
 * 。问有多少个整数符合W的形式并且比X大？
 * 
 * 【输入形式】多组数据，每组数据两行，第一行是W，第二行是X，它们长度相同，在[1..10]之间。
 * 
 * 【输出形式】每行一个整数表示结果。
 * 
 * 【样例输入】
 * 
 * 36?1?8 236428 8?3 910 ? 5
 * 
 * 【样例输出】
 * 
 * 100 0 4
 */
public class Test45 {
	private static final boolean commit = false;

	// 统计字符串问号
	public static int countStrQue(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '?') {
				count++;
			}
		}
		return count;
	}

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
		while (scanner.hasNext()) {
			// 输入w和x
			String w = scanner.next();
			String x = scanner.next();
			// 获取第一个位置问号
			int firstQues = w.indexOf('?');
			if (firstQues >= 1) {
				int wBefQues = Integer.parseInt(w.substring(0, firstQues));
				int xBefQues = Integer.parseInt(x.substring(0, firstQues));
				// 完全大于
				if (wBefQues > xBefQues) {
					System.out.println(countStrQue(w) * 10);
					continue;
				}
				// 完全小于
				else if (wBefQues < xBefQues) {
					System.out.println(0);
					continue;
				}
			}
			// 问号前面部分等于或者问号在0号位的情况
			while (w.contains("?")) {
				int count = 0;
				for (int i = firstQues; i < w.length(); i++) {
					char chw = w.charAt(i);
					char chx = x.charAt(i);
					if (chw == '?') {
						count += '9' - chw;
					}
				}
			}
		}
	}
}
