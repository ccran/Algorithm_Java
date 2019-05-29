package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main201703_3 {
public static boolean commit = false;
	/**
	 *  测试用例
		# Heading
		
		## Sub-heading
		
		Paragrahps are separated
		by a black line.
		
		Text attrribute _italic_.
		
		Bullet list:
		
		* apples
		* oranges
		* pears
		
		A _[link](http://example.com)_
	 */

	//行内处理
	public static String innerLineDeal(String line){
		StringBuilder sb = new StringBuilder();
		//先处理强调
		boolean left = true;
		for(int i=0;i<line.length();i++){
			if(line.charAt(i)=='_'){
				if(left){
					sb.append("<em>");
				}else{
					sb.append("</em>");
				}
				left = !left;
			}else{
				sb.append(line.charAt(i));
			}
		}
		//处理超链接
		int start = 0;
		while(sb.indexOf("[",start)!=-1){
			int leftMidBrackets = sb.indexOf("[",start),
					rightMidBrackets = sb.indexOf("]",start),
					leftSmBrackets =sb.indexOf("(",start),
					rightSmBrackets = sb.indexOf(")",start);
			String link = "<a href=\""+sb.substring(leftSmBrackets+1, rightSmBrackets)+"\">"
					+sb.substring(leftMidBrackets+1, rightMidBrackets)+"</a>";
			sb.replace(leftMidBrackets, rightSmBrackets+1, link);
			start = leftMidBrackets+link.length();
		}
		return sb.toString();
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
		//列表
		List<String> lists = new ArrayList<>();
		//段落
		String params = "";
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			//空行判断列表是否为空
			if(line.isEmpty()){
				if(lists.isEmpty() && params.isEmpty()){
					continue;
				}else{
					if(!lists.isEmpty()){
						// 处理列表
						String listsStr = "<ul>\n";
						for (String item : lists) {
							// 每行处理
							item = innerLineDeal(item);
							listsStr += "<li>" + item + "</li>\n";
						}
						listsStr += "</ul>";
						System.out.println(listsStr);
						lists.clear();
					}
					if(!params.isEmpty()){
						//处理段落
						params = innerLineDeal(params);
						System.out.println("<p>"+params+"</p>");
						params="";
					}
				}
			}else{
				//区块处理
				//标题
				if(line.startsWith("#")){
					//获取标题级别
					int lastAlarmIndex = line.lastIndexOf('#');
					int headerLevel = lastAlarmIndex+1;
					//最后一个空格
					int lastSpaceIndex = line.lastIndexOf(' ');
					//替换#号以及删除多余空格
					line = line.substring(lastSpaceIndex+1, line.length());
					line = "<h"+headerLevel+">"+line+"</h"+headerLevel+">";
					//行内处理
					line = innerLineDeal(line);
					System.out.println(line);
				}
				//列表
				else if(line.startsWith("*")){
					//最后一个空格
					int lastSpaceIndex = line.lastIndexOf(' ');
					//替换#号以及删除多余空格
					line = line.substring(lastSpaceIndex+1, line.length());
					lists.add(line);
				}
				//段落
				else{
					if(params.isEmpty()){
						params+=line;
					}else{
						params+="\n"+line;
					}
				}
			}
		}
		if(!lists.isEmpty()){
			// 处理列表
			String listsStr = "<ul>\n";
			for (String item : lists) {
				// 每行处理
				item = innerLineDeal(item);
				listsStr = "<li>" + item + "</li>\n";
			}
			listsStr += "</ul>";
			System.out.println(listsStr);
			lists.clear();
		}
		if(!params.isEmpty()){
			//处理段落
			params = innerLineDeal(params);
			System.out.println("<p>"+params+"</p>");
			params="";
		}
	}
}
