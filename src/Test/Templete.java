package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Templete{
	public static boolean commit = false;
	
	/**
	 * 
	输入格式
　　    输入数据有任意多行，每一行是一条记录。保证输入合法。股数为不超过10的8次的正整数，
            出价为精确到恰好小数点后两位的正实数，且不超过10000.00。
            
            输入格式
    1 ≤ n, m ≤ 1,000，矩阵中的数都是不超过1000的非负整数。
	 */
	//查找最小值
	public static int findMin(int[] arr){
		int min = Integer.MAX_VALUE;//2 147 483 647 大概2*10^9
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min = arr[i];
			}
		}
		return min;
	}
	
	//计算中值
	public static int calcMid(int left,int right){
		return left+(right-left)/2;
	}
	
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
		/*
		 input:
		 2
		 hello world
		 ni hao
		 */
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<n;i++){
			System.out.println(scanner.nextLine());
		}
		
		
//		System.out.println(0x7fffffff);
//		System.out.println(0x7fffffff+1);
//		System.out.println(0x80000000);//补码
//		System.out.println(findMin(new int[]{-123121,2,3}));
//		System.out.println(calcMid(1,Integer.MAX_VALUE));
	}
}