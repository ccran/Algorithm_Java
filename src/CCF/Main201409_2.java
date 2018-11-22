package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 问题描述
　　在一个定义了直角坐标系的纸上，画一个(x1,y1)到(x2,y2)的矩形指将横坐标范围从x1到x2，纵坐标范围从y1到y2之间的区域涂上颜色。
　　下图给出了一个画了两个矩形的例子。第一个矩形是(1,1) 到(4, 4)，用绿色和紫色表示。第二个矩形是(2, 3)到(6, 5)
，用蓝色和紫色表示。图中，一共有15个单位的面积被涂上颜色，其中紫色部分被涂了两次，但在计算面积时只计算一次
在实际的涂色过程中，所有的矩形都涂成统一的颜色，图中显示不同颜色仅为说明方便。

　　给出所有要画的矩形，请问总共有多少个单位的面积被涂上颜色。
输入格式
　　输入的第一行包含一个整数n，表示要画的矩形的个数。
　　接下来n行，每行4个非负整数，分别表示要画的矩形的左下角的横坐标与纵坐标，以及右上角的横坐标与纵坐标。
输出格式
　　输出一个整数，表示有多少个单位的面积被涂上颜色。
样例输入
2
1 1 4 4
2 3 6 5
样例输出
15
评测用例规模与约定
　　1<=n<=100，0<=横坐标、纵坐标<=100。
 */
public class Main201409_2 {
	public static boolean commit = false;
	public static final int SIZE = 101;
	
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
		int[][] matrix = new int[SIZE][SIZE];
		int num = scanner.nextInt();
		for(int i=0;i<num;i++){
			int x1=scanner.nextInt(),y1=scanner.nextInt()
					,x2=scanner.nextInt(),y2=scanner.nextInt();
			for(int m=x1+1;m<=x2;m++){
				for(int n=y1+1;n<=y2;n++){
					matrix[m][n] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=1;i<SIZE;i++){
			for(int j=1;j<SIZE;j++){
				if(matrix[i][j]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
