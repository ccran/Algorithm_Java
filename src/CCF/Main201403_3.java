package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 问题描述
　　请你写一个命令行分析程序,用以分析给定的命令行里包含哪些选项。每个命令行由若干个字符串组成,它们之间恰好由一个空格分隔。
这些字符串中的第一个为该命令行工具的名字,由小写字母组成,你的程序不用对它进行处理。在工具名字之后可能会包含若干选项,然后可能会包含一 些不是选项的参数。
　　选项有两类:带参数的选项和不带参数的选项。一个合法的无参数选项的形式是一个减号后面跟单个小写字母,如"-a" 或"-b"。
而带参数选项则由两个由空格分隔的字符串构成,前者的格式要求与无参数选项相同,后者则是该选项的参数,是由小写字母,数字和减号组成的非空字符串。
　　该命令行工具的作者提供给你一个格式字符串以指定他的命令行工具需要接受哪些选项。这个字符串由若干小写字母和冒号组成,
其中的每个小写字母表示一个该程序接受的选项。如果该小写字母后面紧跟了一个冒号,它就表示一个带参数的选项,否则则为不带参数的选项。
例如, "ab:m:" 表示该程序接受三种选项,即"-a"(不带参数),"-b"(带参数), 以及"-m"(带参数)。
　　命令行工具的作者准备了若干条命令行用以测试你的程序。对于每个命令行,你的工具应当一直向后分析。
当你的工具遇到某个字符串既不是合法的选项,又不是某个合法选项的参数时,分析就停止。
命令行剩余的未分析部分不构成该命令的选项,因此你的程序应当忽略它们。
输入格式
　　输入的第一行是一个格式字符串,它至少包含一个字符,且长度不超过 52。
格式字符串只包含小写字母和冒号,保证每个小写字母至多出现一次,不会有两个相邻的冒号,也不会以冒号开头。
　　输入的第二行是一个正整数 N(1 ≤ N ≤ 20),表示你需要处理的命令行的个数。
　　接下来有 N 行,每行是一个待处理的命令行,它包括不超过 256 个字符。
该命令行一定是若干个由单个空格分隔的字符串构成,每个字符串里只包含小写字母,数字和减号。
输出格式
　　输出有 N 行。其中第 i 行以"Case i:" 开始,
然后应当有恰好一个空格,然后应当按照字母升序输出该命令行中用到的所有选项的名称,对于带参数的选项,在输出它的名称之后还要输出它的参数。
如果一个选项在命令行中出现了多次,只输出一次。如果一个带参数的选项在命令行中出 现了多次,只输出最后一次出现时所带的参数。
样例输入
albw:x
4
ls -a -l -a documents -b
ls
ls -w 10 -x -w 15
ls -a -b -c -d -e -l
样例输出
Case 1: -a -l
Case 2:
Case 3: -w 15 -x
Case 4: -a -b
 */
public class Main201403_3 {
public static boolean commit = false;
	
	public static class Option implements Comparable<Option>{
		public String name;
		public String param;
		
		public Option(String name, String param) {
			super();
			this.name = name;
			this.param = param;
		}

		@Override
		public String toString() {
			if(param.isEmpty()){
				return " -"+name;
			}else{
				return " -"+name+" "+param;
			}
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.name.equals(((Option)obj).name);
		}

		@Override
		public int compareTo(Option o) {
			return this.name.compareTo(o.name);
		}
	}

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
		//输入选项
		String optionStr = scanner.next();
		//选项类型1为带参，-1为不带参，0为不存在该参数
		int[] order = new int[26];
		for(int i=0;i<optionStr.length();i++){
			//默认为不带参
			char ch = optionStr.charAt(i);
			order[ch-'a'] = -1;
			//后面接冒号则为带参数
			if(i+1<optionStr.length() 
					&& optionStr.charAt(i+1)==':'){
				order[ch-'a']=1;
				i++;
			}
		}
		//输入命令
		int n = scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<n;i++){
			//分解成单个选项
			String command = scanner.nextLine();
			String[] optionArr = command.split(" ");
			//TreeSet根据comparable接口进行升序排列，实现comparable接口
			Set<Option> optionSet = new TreeSet<>();
			for(int j=1;j<optionArr.length;j++){
				String singleOption = optionArr[j];
				//如果当前参数合法，长度为2，第一个字符为-，第二个字符为小写字母
				if(singleOption.length()==2 && singleOption.charAt(0)=='-'
						&& Character.getType(singleOption.charAt(1))==Character.LOWERCASE_LETTER){
					//判断选项类型
					int orderType = order[singleOption.charAt(1)-'a'];
					//选项不存在
					if(0==orderType){
						break;
					}
					//带参数选项
					else if(1==orderType){
						if(j+1<optionArr.length){
							Option option = new Option(String.valueOf(singleOption.charAt(1)),
									optionArr[j+1]);
							//存在旧的项则先进行移除，set根据equals进行判断，重写equals
							if(optionSet.contains(option)){
								optionSet.remove(option);
							}
							optionSet.add(option);
							j++;
						}
					}
					//不带参数选项
					else{
						Option option = new Option(String.valueOf(singleOption.charAt(1)),
								"");
						optionSet.add(option);
					}
				}else{
					break;
				}
			}
			//输出结果
			System.out.print("Case "+String.valueOf(i+1)+":");
			if(optionSet.isEmpty()){
				System.out.println(" ");
			}else{
				for(Option option:optionSet){
					System.out.print(option);
				}
				System.out.println();
			}
		}
	}
}
