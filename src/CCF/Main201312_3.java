package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 
问题描述
　　在横轴上放了n个相邻的矩形，每个矩形的宽度是1，而第i（1 ≤ i ≤ n）个矩形的高度是hi。这n个矩形构成了一个直方图。
例如，下图中六个矩形的高度就分别是3, 1, 6, 5, 2, 3。
　　请找出能放在给定直方图里面积最大的矩形，它的边要与坐标轴平行。对于上面给出的例子
，最大矩形如下图所示的阴影部分，面积是10。
输入格式
　　第一行包含一个整数n，即矩形的数量(1 ≤ n ≤ 1000)。
　　第二行包含n 个整数h1, h2, … , hn，相邻的数之间由空格分隔。(1 ≤ hi ≤ 10000)。hi是第i个矩形的高度。
输出格式
　　输出一行，包含一个整数，即给定直方图内的最大矩形的面积。
样例输入
6
3 1 6 5 2 3
样例输出
10
 */
public class Main201312_3 {
	public static boolean commit = true;

	// 获取最大面积
	public static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		// 以当前元素作为高度向两边进行宽延伸获取面积
		// 第一个位置和最后一个位置作为哨兵
		for (int i = 1; i < arr.length-1; i++) {
			//获取高度
			int height = arr[i];
			//统计宽度
			int width = 1;
			int m = i - 1, n = i + 1;
			while (arr[m] >= arr[i] || arr[n] >= arr[i]) {
				if (arr[m] >= arr[i]) {
					m--;
					width++;
				}
				if(arr[n]>=arr[i]){
					n++;
					width++;
				}
			}
			//获取最大面积
			max = Math.max(max, height * width);
		}
		return max;
	}

	public static void main(String[] args) {
		InputStream is = null;
		if (commit) {
			is = System.in;
		} else {
			try {
				is = new FileInputStream("F:\\in.txt");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Scanner scanner = new Scanner(is);
		//输入数据第一个位置和最后一个位置作为哨兵
		int n = scanner.nextInt();
		int[] arr = new int[n+2];
		for(int i = 1; i < arr.length-1; i++){
			arr[i] = scanner.nextInt();
		}
		System.out.println(getMax(arr));
	}

}
