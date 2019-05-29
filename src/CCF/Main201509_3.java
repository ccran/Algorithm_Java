package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main201509_3 {
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
		//输入待替换数据
		int m = scanner.nextInt(),
				n = scanner.nextInt();
		scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++){
			sb.append(scanner.nextLine()+"\n");
		}
		//创建替换map
		Map<String, String> replaceStrMap = new HashMap<>();
		//正则提取{{}}中间的值
		Pattern pattern = Pattern.compile("\\{\\{ (\\w+?) \\}\\}");
		Matcher matcher = pattern.matcher(sb.toString());
		while(matcher.find()){
			String grp = matcher.group(1);
			replaceStrMap.put(grp, "");
		}
		//输入替换word
		for(int i=0;i<n;i++){
			String key = scanner.next();
			String value = scanner.nextLine();
			value = value.substring(2,value.length()-1);
			replaceStrMap.put(key, value);
		}
		//开始替换
		String res = sb.toString();
		for(Map.Entry<String, String> entry:replaceStrMap.entrySet()){
			res = res.replace("{{ "+entry.getKey()+" }}", entry.getValue());
		}
		//输出结果
		System.out.print(res);
	}
}
