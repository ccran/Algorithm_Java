package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
问题描述
　　在操作系统中，数据通常以文件的形式存储在文件系统中。文件系统一般采用层次化的组织形式，由目录（或者文件夹）和文件构成，形成一棵树的形状。文件有内容，用于存储数据。目录是容器，可包含文件或其他目录。同一个目录下的所有文件和目录的名字各不相同，不同目录下可以有名字相同的文件或目录。
　　为了指定文件系统中的某个文件，需要用路径来定位。在类 Unix 系统（Linux、Max OS X、FreeBSD等）中，路径由若干部分构成，每个部分是一个目录或者文件的名字，相邻两个部分之间用 / 符号分隔。
　　有一个特殊的目录被称为根目录，是整个文件系统形成的这棵树的根节点，用一个单独的 / 符号表示。在操作系统中，有当前目录的概念，表示用户目前正在工作的目录。根据出发点可以把路径分为两类：
　　 绝对路径：以 / 符号开头，表示从根目录开始构建的路径。
　　 相对路径：不以 / 符号开头，表示从当前目录开始构建的路径。

　　例如，有一个文件系统的结构如下图所示。在这个文件系统中，有根目录 / 和其他普通目录 d1、d2、d3、d4，以及文件 f1、f2、f3、f1、f4。其中，两个 f1 是同名文件，但在不同的目录下。

　　对于 d4 目录下的 f1 文件，可以用绝对路径 /d2/d4/f1 来指定。如果当前目录是 /d2/d3，这个文件也可以用相对路径 ../d4/f1 来指定，这里 .. 表示上一级目录（注意，根目录的上一级目录是它本身）。还有 . 表示本目录，例如 /d1/./f1 指定的就是 /d1/f1。注意，如果有多个连续的 / 出现，其效果等同于一个 /，例如 /d1///f1 指定的也是 /d1/f1。
　　本题会给出一些路径，要求对于每个路径，给出正规化以后的形式。一个路径经过正规化操作后，其指定的文件不变，但是会变成一个不包含 . 和 .. 的绝对路径，且不包含连续多个 / 符号。如果一个路径以 / 结尾，那么它代表的一定是一个目录，正规化操作要去掉结尾的 /。若这个路径代表根目录，则正规化操作的结果是 /。若路径为空字符串，则正规化操作的结果是当前目录。
输入格式
　　第一行包含一个整数 P，表示需要进行正规化操作的路径个数。
　　第二行包含一个字符串，表示当前目录。
　　以下 P 行，每行包含一个字符串，表示需要进行正规化操作的路径。
输出格式
　　共 P 行，每行一个字符串，表示经过正规化操作后的路径，顺序与输入对应。
样例输入
7
/d2/d3
/d2/d4/f1
../d4/f1
/d1/./f1
/d1///f1
/d1/
///
/d1/../../d2
样例输出
/d2/d4/f1
/d2/d4/f1
/d1/f1
/d1/f1
/d1
/
/d2
评测用例规模与约定
　　1 ≤ P ≤ 10。
　　文件和目录的名字只包含大小写字母、数字和小数点 .、减号 - 以及下划线 _。
　　不会有文件或目录的名字是 . 或 .. ，它们具有题目描述中给出的特殊含义。
　　输入的所有路径每个长度不超过 1000 个字符。
　　输入的当前目录保证是一个经过正规化操作后的路径。
　　对于前 30% 的测试用例，需要正规化的路径的组成部分不包含 . 和 .. 。
　　对于前 60% 的测试用例，需要正规化的路径都是绝对路径。
 */
public class Main201604_3 {
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
		int p = scanner.nextInt();scanner.nextLine();
		String currentDir = scanner.nextLine();
		//正则匹配
		for(int i=0;i<p;i++){
			//末尾加入"/"以便进行正则匹配
			String dir = scanner.nextLine();
			//空字符串为当前目录
			if(dir.isEmpty()){
				System.out.println(currentDir);
			}else{
				//通过"/"进行分隔
				String[] splitDir = dir.split("/");
				List<String> dirList = new ArrayList<>();
				//相对路径累加当前目录
				if(!dir.startsWith("/")){
					String[] currentStrSplit = currentDir.split("/");
					for(String splitItem:currentStrSplit){
						if(!splitItem.isEmpty()){
							dirList.add(splitItem);
						}
					}
				}
				//统计正常目录
				for(String dirItem:splitDir){
					//空项或者当前目录忽略
					if(dirItem.isEmpty() || dirItem.equals(".")){
						continue;
					}
					//退回上级
					else if(dirItem.equals("..")){
						if(!dirList.isEmpty()){
							dirList.remove(dirList.size()-1);
						}
					}
					//进入新目录
					else{
						dirList.add(dirItem);
					}
				}
				//得到最终正规化路径
				//为空则为根目录
				if(dirList.isEmpty()){
					System.out.println("/");
				}
				else{
					StringBuilder sb = new StringBuilder();
					for(String dirItem:dirList){
						sb.append("/").append(dirItem);
					}
					System.out.println(sb);
				}
			}
		}
	}
}
