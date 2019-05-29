package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 *	
问题描述
　　有 N 个非零且各不相同的整数。请你编一个程序求出它们中有多少对相反数(a 和 -a 为一对相反数)。
输入格式
　　第一行包含一个正整数 N。(1 ≤ N ≤ 500)。
　　第二行为 N 个用单个空格隔开的非零整数,每个数的绝对值不超过1000,保证这些整数各不相同。
输出格式
　　只输出一个整数,即这 N 个数中包含多少对相反数。
样例输入
5
1 2 3 -1 -2
样例输出
2 
 */
public class Main201403_1 {

public static boolean commit = false;
	
	public static boolean containAbs(int[] arr,int key,int length){
		for(int i=0;i<length;i++){
			if(arr[i]==-key){
				return true;
			}
		}
		return false;
	}

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
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
		for(int i=0;i<n;i++){
			int key = scanner.nextInt();
			if(containAbs(arr, key, i)){
				cnt++;
			}
			arr[i] = key;
		}
		System.out.println(cnt);
	}

}
