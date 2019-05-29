package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main201412_2 {
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
		//输入矩阵
		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		//z型输出
		int startx = 0,starty = 0;
		boolean right = true;
		System.out.print(matrix[startx][starty]);
		while(true){
			//n==1
			if(startx==n-1 && starty==n-1)
				break;
			//右走
			if(starty+1<n){
				System.out.print(" "+matrix[startx][++starty]);
				if(startx==n-1 && starty==n-1)
					break;
				//x为0
				if(startx==0){
					//斜下走
					while(starty>0 && startx<n-1){
						System.out.print(" "+matrix[++startx][--starty]);	
					}
				}
				//x为n-1
				else{
					//斜上走
					while(startx>0 && starty<n-1){
						System.out.print(" "+matrix[--startx][++starty]);
					}
				}
			}
			//下走
			if(startx+1<n){
				System.out.print(" "+matrix[++startx][starty]);
				//y为0
				if(starty==0){
					//斜上走
					while(startx>0 && starty<n-1){
						System.out.print(" "+matrix[--startx][++starty]);
					}
				}
				//y为n-1
				else{
					//斜下走
					while(starty>0 && startx<n-1){
						System.out.print(" "+matrix[++startx][--starty]);	
					}
				}
			}
		}
	}
}
