package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main201512_2 {
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
		//输入矩阵
		int n = scanner.nextInt(),m = scanner.nextInt();
		int[][] matrix = new int[n][m];
		boolean[][] tag = new boolean[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		//判断可消除元素
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(j+2<m){
					if(matrix[i][j] == matrix[i][j+1] &&
							matrix[i][j+1]==matrix[i][j+2]){
						tag[i][j] = tag[i][j+1] = tag[i][j+2] = true;
					}
				}
				if(i+2<n){
					if(matrix[i][j] == matrix[i+1][j] &&
							matrix[i+1][j]==matrix[i+2][j]){
						tag[i][j] = tag[i+1][j] = tag[i+2][j] = true;
					}
				}
			}
		}
		//元素置0
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(tag[i][j])
					matrix[i][j] = 0;
				if(j==0){
					System.out.print(matrix[i][j]);
				}else{
					System.out.print(" "+matrix[i][j]);
				}
			}
			System.out.println();
		}
	}
}
