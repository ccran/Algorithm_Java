package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 
	　俄罗斯方块是俄罗斯人阿列克谢·帕基特诺夫发明的一款休闲游戏。
	　　游戏在一个15行10列的方格图上进行，方格图上的每一个格子可能已经放置了方块，或者没有放置方块。每一轮，都会有一个新的由4个小方块组成的板块从方格图的上方落下，玩家可以操作板块左右移动放到合适的位置，当板块中某一个方块的下边缘与方格图上的方块上边缘重合或者达到下边界时，板块不再移动，如果此时方格图的某一行全放满了方块，则该行被消除并得分。
	　　在这个问题中，你需要写一个程序来模拟板块下落，你不需要处理玩家的操作，也不需要处理消行和得分。
	　　具体的，给定一个初始的方格图，以及一个板块的形状和它下落的初始位置，你要给出最终的方格图。
	输入格式
	　　输入的前15行包含初始的方格图，每行包含10个数字，相邻的数字用空格分隔。如果一个数字是0，表示对应的方格中没有方块，如果数字是1，则表示初始的时候有方块。输入保证前4行中的数字都是0。
	　　输入的第16至第19行包含新加入的板块的形状，每行包含4个数字，组成了板块图案，同样0表示没方块，1表示有方块。输入保证板块的图案中正好包含4个方块，且4个方块是连在一起的（准确的说，4个方块是四连通的，即给定的板块是俄罗斯方块的标准板块）。
	　　第20行包含一个1到7之间的整数，表示板块图案最左边开始的时候是在方格图的哪一列中。注意，这里的板块图案指的是16至19行所输入的板块图案，如果板块图案的最左边一列全是0，则它的左边和实际所表示的板块的左边是不一致的（见样例）
	输出格式
	　　输出15行，每行10个数字，相邻的数字之间用一个空格分隔，表示板块下落后的方格图。注意，你不需要处理最终的消行。
	样例输入
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 1 0 0
	0 0 0 0 0 0 1 0 0 0
	0 0 0 0 0 0 1 0 0 0
	1 1 1 0 0 0 1 1 1 1
	0 0 0 0 1 0 0 0 0 0
	0 0 0 0
	0 1 1 1
	0 0 0 1
	0 0 0 0
	3
	样例输出
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 1 0 0
	0 0 0 0 0 0 1 0 0 0
	0 0 0 0 0 0 1 0 0 0
	1 1 1 1 1 1 1 1 1 1
	0 0 0 0 1 1 0 0 0 0
 */
public class Main201604_2 {
	public static boolean commit = false;
	public static final int ROW = 15;
	public static final int COLUMN = 10;
	public static final int BLOCK = 4;
	
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
		//输入方格图
		Scanner scanner = new Scanner(is);
		int[][] grid = new int[ROW][COLUMN];
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COLUMN;j++){
				grid[i][j] = scanner.nextInt();
			}
		}
		//输入板块
		int[] rowGrid = new int[BLOCK],colGrid = new int[BLOCK];
		int record = 0;
		int[][] block = new int[BLOCK][BLOCK];
		for (int i = 0; i < BLOCK; i++) {
			for (int j = 0; j < BLOCK; j++) {
				block[i][j] = scanner.nextInt();
				//记录出现方块的位置
				if (block[i][j] == 1) {
					rowGrid[record] = i;
					colGrid[record] = j;
					record++;
				}
			}
		}
		int startColIndex = scanner.nextInt()-1;
		int location = -1;
		for(int i=0;i<ROW;i++){
			if(location!=-1)
				break;
			for(int j=0;j<BLOCK;j++){
				int nextRow = i+rowGrid[j]+1,
						col = startColIndex+colGrid[j];
				if(nextRow>ROW || col>=COLUMN){
					continue;
				}
				//是否抵达最后一层
				if(nextRow==ROW){
					location = i;
					break;
				}
				//有板块的下一格是否存在板块
				if(grid[nextRow][col]==1){
					location = i;
					break;
				}
			}
		}
		//填充数据
		for(int i=0;i<BLOCK;i++){
			for(int j=0;j<BLOCK;j++){
				if(location+i<ROW && startColIndex+j<COLUMN && block[i][j]==1)
					grid[location+i][startColIndex+j] = 1;
			}
		}
		//输出数据
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COLUMN;j++){
				if(j==0){
					System.out.print(grid[i][j]);
				}
				else{
					System.out.print(" "+grid[i][j]);
				}
			}
			System.out.println();
		}
	}
}
