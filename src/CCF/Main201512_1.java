package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 问题描述
	　　给定一个十进制整数n，输出n的各位数字之和。
	输入格式
	　　输入一个整数n。
	输出格式
	　　输出一个整数，表示答案。
	样例输入
	20151220
	样例输出
	13
	样例说明
	　　20151220的各位数字之和为2+0+1+5+1+2+2+0=13。
	评测用例规模与约定
	　　所有评测用例满足：0 ≤ n ≤ 1000000000。
 */
public class Main201512_1 {
public static boolean commit = false;
	
	public static void main(String[] args) throws IOException {
		InputStream is = null;
		try {
			if (commit) {
				is = System.in;
			} else {
				is = new FileInputStream("F:\\in.txt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(is);
		String nStr = scanner.nextLine();
		int res = 0;
		for(int i=0;i<nStr.length();i++){
			res+=nStr.charAt(i)-'0';
		}
		System.out.println(res);
	}
}
