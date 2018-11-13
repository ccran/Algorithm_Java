package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 试题编号： 201312-1 
 * 试题名称： 出现次数最多的数 
 * 时间限制： 1.0s 
 * 内存限制： 256.0MB 
 * 问题描述： 问题描述
 * 给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。 
 * 输入格式 
 * 输入的第一行只有一个正整数n(1 ≤ n ≤
 * 1000)，表示数字的个数。 输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤
 * n)。相邻的数用空格分隔。
 * 输出格式
 * 输出这n个次数中出现次数最多的数。如果这样的数有多个，输出其中最小的一个。 
 * 样例输入
 * 6 10 1 10 20 30 20 
 * 样例输出 
 * 10
 */
public class Main201312_1 {
	static boolean commit = false;
	
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
		//输入数据
		int n = scanner.nextInt();
		//出现次数统计
		int[] numTimes = new int[10001];
		//最大次数以及对应的最小的数
		int maxTimes = 0,minNum = 10000;
		for(int i=0;i<n;i++){
			int tmp = scanner.nextInt();
			numTimes[tmp]++;
			//次数较大则更新最大次数以及所对应最小的数
			if(numTimes[tmp]>maxTimes){
				minNum = tmp;
				maxTimes = numTimes[tmp];
			}
			//次数相同则取较小的数
			else if(numTimes[tmp] == maxTimes){
				if(tmp<minNum){
					minNum = tmp;
				}
			}
		}
		//输出结果
		System.out.println(minNum);
	}

}
