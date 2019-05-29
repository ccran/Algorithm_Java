package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 开关与灯 【问题描述】
 * 给定n个开关和m个灯，第i个开关只能打开部分灯。矩阵a包含n行m列，当aij=1时表示开关i可以打开灯j，否则aij=0。
 * 开始时所有的m个灯都是关着的。
 * 开关只能从状态"关"到"开"。这意味着，对于每个可以打开某个灯的开关，无论你按多少次，这个灯都是开的。
 * 确保当你按下所有开关时，所有的灯都能打开，考虑是否可以忽略其中某个开关也能打开所有的灯。
 * 你的任务是确定是否存在这样的开关可以忽略，而使用其余的n-1个开关来打开所有m个灯。
 * 【输入形式】
 * 输入第1行包含两个整数n和m(1<=n, m<=2000)，表示开关的数量和灯的数量。
 * 接下来的n行，每行包含m个字符，字符aij=1时表示开关i可以打开灯j，否则aij=0。
 * 【输出形式】
 * 如果存在这样的可以忽略的开关，而使用其他n-1个开关打开所有的m个灯，输出"YES"，否则输出"NO"。
 * 【样例输入】
 * 4 5 10101 01000 00111 10000
 * 【样例输出】
 * YES
 */
public class Test42 {
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
		//输入矩阵
		int n = scanner.nextInt(),m = scanner.nextInt();
		int[][] matrix = new int[n][m];
		//开关计数
		int[] switchCount = new int[m];
		for(int i=0;i<n;i++){
			String line = scanner.next();
			for(int j=0;j<m;j++){
				//输入矩阵
				matrix[i][j] = line.charAt(j)-'0';
				//开关计数
				if(matrix[i][j]==1){
					switchCount[j]++;
				}
			}
		}
		//遍历矩阵每行
		boolean existSwitch = false;
		for(int i=0;i<n;i++){
			boolean canCloseAllLight = true;
			//如果不算这个开关可以关掉所有的灯光
			for(int j=0;j<m;j++){
				//所有开关打开后等都没开或者该灯光只能靠自己打开
				if(switchCount[j]==0 || 
						(matrix[i][j]==1 && switchCount[j]==1)){
					canCloseAllLight = false;
					break;
				}
			}
			if(canCloseAllLight){
				existSwitch = true;
				break;
			}
		}
		//输出结果
		if(existSwitch){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
