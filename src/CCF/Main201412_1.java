package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 问题描述
　　涛涛最近要负责图书馆的管理工作，需要记录下每天读者的到访情况。每位读者有一个编号，每条记录用读者的编号来表示。
给出读者的来访记录，请问每一条记录中的读者是第几次出现。
输入格式
　　输入的第一行包含一个整数n，表示涛涛的记录条数。
　　第二行包含n个整数，依次表示涛涛的记录中每位读者的编号。
输出格式
　　输出一行，包含n个整数，由空格分隔，依次表示每条记录中的读者编号是第几次出现。
样例输入
5
1 2 1 1 3
样例输出
1 1 2 3 1
评测用例规模与约定
　　1≤n≤1,000，读者的编号为不超过n的正整数。
 */
public class Main201412_1 {
public static boolean commit = false;
	
	public static void main(String[] args) {
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
		int[] num = new int[1001];
		int n = scanner.nextInt();
		for(int i=0;i<n;i++){
			if(i==0){
				System.out.print(++num[scanner.nextInt()]);
			}else{
				System.out.print(" "+(++num[scanner.nextInt()]));
			}
		}
	}
}
