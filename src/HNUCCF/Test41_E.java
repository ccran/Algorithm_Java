package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * 【问题描述】
 * <p>
 * Vasya有几本电话簿，记录了他的朋友们的电话号码，每一个朋友都可以有一或几个电话号码。
 * <p>
 * Vasya决定整理关于朋友电话号码的信息。给定n个字符串，来自于Vasya的电话簿中的条目。每
 * 一条都以朋友的姓名开头，然后跟着当前条目中的电话号码个数，然后是本人的电话号码。
 * 有可能几个相同的电话被记录在同一个记录中。
 * <p>
 * Vasya还认为，如果电话号码a是电话号码b的后缀（也就是说，号码b以a结尾），
 * 这两个号码被当作同一个电话号码，那么a被认为是无城市代码，它不应该被考虑。
 * <p>
 * 输出整理后Vasya朋友的电话号码信息。有可能两个不同的人有相同的号码。
 * 如果一个人有两个电话号码x和y，x是y的后缀（即y以x结尾），则不输出x。
 * <p>
 * 如果Vasya的电话簿中的某些朋友记录了几次，那么只需要记录一次。
 * <p>
 * 【输入形式】
 * <p>
 * 输入第一行一个整数n(1<=n<=20)，Vasya的电话簿上的条目数。
 * <p>
 * 以下n行后面是描述中的格式记录。 朋友的姓名中不包含空字符，长度不超过10位，由小写英文字母组成。
 * 电话号码个数在1~10之间。每个电话号码的长度范围在1~10之间，可以包含前导0。
 * <p>
 * 【输出形式】
 * <p>
 * 输出Vasya的朋友的电话号码的有序信息。首先输出电话簿中的朋友数目m。
 * <p>
 * 接下来的m行，包含以格式“姓名 电话号码个数 电话号码1 ... 电话号码k"的条目，号码间以空格分隔。
 * 每个记录包含当前朋友的所有电话号码。
 * <p>
 * 每个条目输出按照姓名字母序进行排序，电话号码按照从小到大的顺序排列（注意电话号码："1"<"01"、"12"<"012"，依此类推）
 * <p>
 * 【样例输入】
 * <p>
 * 4
 * ivan 3 123 123 456
 * ivan 2 456 456
 * ivan 8 789 3 23 6 56 9 89 2
 * dasha 2 23 789
 * <p>
 * 【样例输出】
 * <p>
 * 2
 * dasha 2 23 789
 * ivan 4 2 123 456 789
 */
public class Test41_E {
    private static final boolean commit = true;

    //判断一个串a是否是另一个串b的后缀
    public static boolean isSuffix(String longer, String shorter) {
        int index = longer.indexOf(shorter);
        if (index == -1)
            return false;
        return index + shorter.length() == longer.length();
    }
    
    //在一个电话列表里面添加电话
    public static void addPhoneToList(String phone,List<String> phoneList){
    	//列表中没有电话则直接添加
    	if(phoneList.isEmpty()){
    		phoneList.add(phone);
    	}
    	//去掉重复或后缀元素并添加
    	int i = 0;
    	while(i<phoneList.size()){
    		//获取长串和短串
    		String longerStr = phone.length()<phoneList.get(i).length()?phoneList.get(i):phone;
    		String shorterStr = phone.length()<phoneList.get(i).length()?phone:phoneList.get(i);
    		//如果是后缀则进行替换
    		if(isSuffix(longerStr, shorterStr)){
    			phoneList.set(i, longerStr);
    			break;
    		}
    		//移动
    		++i;
    	}
    	//没有重复或后缀元素
    	if(i==phoneList.size()){
    		phoneList.add(phone);
    	}
    }

    //程序入口
    public static void main(String[] args) {
        InputStream inputStream = null;
        //从文件流读取输入
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
        //输入电话号码数
        int m = scanner.nextInt();
        //TreeMap默认根据key升序
        Map<String, List<String>> namePhoneMap = new TreeMap<>();
        //输入联系人以及电话号码
        for (int i = 0; i < m; i++) {
            //输入名称
            String name = scanner.next();
            //判断是否存在了该名称
            if (!namePhoneMap.containsKey(name)) {
                namePhoneMap.put(name, new ArrayList<String>());
            }
            //电话数量
            int phoneNum = scanner.nextInt();
            for (int j = 0; j < phoneNum; j++) {
            	//输入电话
                String inputPhone = scanner.next();
                //添加电话
                addPhoneToList(inputPhone,namePhoneMap.get(name));
            }
        }
        //输出结果
        //联系人数量
        System.out.println(namePhoneMap.size());
        //详细联系人
        for(Map.Entry<String, List<String>> contact:namePhoneMap.entrySet()){
        	//输出名称以及电话个数
        	System.out.print(contact.getKey()+" "+contact.getValue().size());
        	//对电话号码排序
        	Collections.sort(contact.getValue(),new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int i1 = Integer.parseInt(o1);
					int i2 = Integer.parseInt(o2);
					if(i1==i2){
						return o1.length()-o2.length();
					}else{
						return i1-i2;
					}
				}
			});
        	//输出结果
        	for(String phone:contact.getValue()){
        		System.out.print(" "+phone);
        	}
        	System.out.println();
        }
    }
}
