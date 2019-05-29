package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】sun所在学校的教室座位每天都是可以预占的。
 * 一个人可以去占多个座位，而且一定是要连续的座位，如果占不到他所要求的这么多座位，那么他就一个座位也不要了。为了降低难度，每次分配座位按座位号从小到大查找，采用最先适配法分配座位。
 * 
 * 【输入形式】输入有多组数据。
 * 每组数据输入座位排数n，0<n<=100（座位的排列数相等，座位是按每行从左到右依次排序的,，第1行的最右边一个座位与第二行的第一个座位视为连续座位），m（
 * 0<m<=min(100,n*n) ）个人。 然后输入k（0<k<=100），最后输入k个命令。 命令只有两种： 1.in id
 * num（代表id,0<=id<m,要占num个座位，若占不到连续的num(0<num<=20)个座位表示该命令无效） 2.out
 * id（代表id要释放他之前占的所有座位） 注意：如果id之前占过座还没释放那么之后他的in命令都是无效的，
 * 如果id之前没占过座位那么他的out命令也是无效的。
 * 
 * 【输出形式】对每个in命令输出yes或者no，如果命令有效则输出yes，无效则输出no。 在yes no后面只带有回车，不带其他任何字符。
 * 
 * 【样例输入】
 * 
 * 4 10
 * 
 * 9
 * 
 * in 1 7
 * 
 * in 2 3
 * 
 * in 3 3
 * 
 * in 3 3
 * 
 * in 4 3
 * 
 * out 2
 * 
 * in 5 6
 * 
 * out 3
 * 
 * in 5 6
 * 
 * 【样例输出】
 * 
 * yes yes
 * 
 * yes
 * 
 * no
 * 
 * yes
 * 
 * yes
 * 
 * no
 * 
 * yes
 * 
 * yes
 */
public class Test46 {
	private static final boolean commit = false;

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
		// 循环获取输入
		while (scanner.hasNext()) {
			// do something
		}
	}
}
