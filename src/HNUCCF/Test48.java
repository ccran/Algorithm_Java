package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * 
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： “hello xiao
 * mi”-> “mi xiao hello”
 * 
 * 【输入形式】
 * 
 * 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符) 【输出形式】
 * 
 * 对于每个测试示例，要求输出句子中单词反转后形成的句子 【样例输入】
 * 
 * hello xiao mi I am a student 【样例输出】
 * 
 * mi xiao hello student a am I
 */
public class Test48 {
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
		while (scanner.hasNext()) {
			String[] sentence = scanner.nextLine().split(" ");
			for (int i = sentence.length - 1; i >= 0; i--) {
				if (i == sentence.length - 1) {
					System.out.print(sentence[i]);
				} else {
					System.out.print(" "+sentence[i]);
				}
			}
			System.out.println();
		}
	}
}
