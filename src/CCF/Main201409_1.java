package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 问题描述
　　给定n个不同的整数，问这些数中有多少对整数，它们的值正好相差1。
输入格式
　　输入的第一行包含一个整数n，表示给定整数的个数。
　　第二行包含所给定的n个整数。
输出格式
　　输出一个整数，表示值正好相差1的数对的个数。
样例输入
6
10 2 6 3 7 8
样例输出
3
样例说明
　　值正好相差1的数对包括(2, 3), (6, 7), (7, 8)。
评测用例规模与约定
　　1<=n<=1000，给定的整数为不超过10000的非负整数。
 */
public class Main201409_1 {
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
		int[] num = new int[10001];
		int n = scanner.nextInt();
		for(int i=0;i<n;i++){
			num[scanner.nextInt()] = 1;
		}
		int cnt = 0;
		for(int i=0;i<num.length;i++){
			if(i+1<num.length){
				if(num[i]==1 && num[i+1]==1){
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
