package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 问题描述
　　给定一个公司的网络，由n台交换机和m台终端电脑组成，交换机与交换机、交换机与电脑之间使用网络连接。交换机按层级设置，编号为1的交换机为根交换机，层级为1。其他的交换机都连接到一台比自己上一层的交换机上，其层级为对应交换机的层级加1。所有的终端电脑都直接连接到交换机上。
　　当信息在电脑、交换机之间传递时，每一步只能通过自己传递到自己所连接的另一台电脑或交换机。请问，电脑与电脑之间传递消息、或者电脑与交换机之间传递消息、或者交换机与交换机之间传递消息最多需要多少步。
输入格式
　　输入的第一行包含两个整数n, m，分别表示交换机的台数和终端电脑的台数。
　　第二行包含n - 1个整数，分别表示第2、3、……、n台交换机所连接的比自己上一层的交换机的编号。
第i台交换机所连接的上一层的交换机编号一定比自己的编号小。
　　第三行包含m个整数，分别表示第1、2、……、m台终端电脑所连接的交换机的编号。
输出格式
　　输出一个整数，表示消息传递最多需要的步数。
样例输入
4 2
1 1 3
2 1
样例输出
4
样例说明
　　样例的网络连接模式如下，其中圆圈表示交换机，方框表示电脑：

　　其中电脑1与交换机4之间的消息传递花费的时间最长，为4个单位时间。
样例输入
4 4
1 2 2
3 4 4 4
样例输出
4
样例说明
　　样例的网络连接模式如下：

　　其中电脑1与电脑4之间的消息传递花费的时间最长，为4个单位时间。
评测用例规模与约定
　　前30%的评测用例满足：n ≤ 5, m ≤ 5。
　　前50%的评测用例满足：n ≤ 20, m ≤ 20。
　　前70%的评测用例满足：n ≤ 100, m ≤ 100。
　　所有评测用例都满足：1 ≤ n ≤ 10000，1 ≤ m ≤ 10000。
 */
public class Main201503_4 {
	private static final boolean commit = false;
	
//	private static int bfs(int start,int[][] graph,int[] visit,int max){
//		visit[start] = 1;
//		
//	}
	
	public static void main(String[] args) {
		InputStream is = null;
		try{
			if(commit){
				is = System.in;
			}else{
				is = new FileInputStream("F:\\in.txt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(is);
		//输入图
		int n = scanner.nextInt(),m = scanner.nextInt();
		int[][] graph = new int[n+m][n+m];
		for(int i=1;i<graph.length;i++){
			int other = scanner.nextInt();
			graph[i][other-1] = graph[other-1][i] = 1;
		}
		//bfs统计最大步数
		
	}
}