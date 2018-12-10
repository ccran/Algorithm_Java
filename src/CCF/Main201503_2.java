package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main201503_2 {
	public static boolean commit = false;
	
	public static class Num{
		public short num;
		public short times;
		
		@Override
		public String toString() {
			return String.valueOf(num)+" "+String.valueOf(times);
		}
	}
	
	public static void main(String[] args) {
		InputStream is = null;
		try{
			if(commit){
				is = System.in;
			}else{
				is = new FileInputStream("F:\\in.txt");
			}
		}catch(Exception e){}
		Scanner scanner = new Scanner(is);
		//输入数据到num - NumObj map
		Map<Short, Num> numTimesMap = new HashMap<>();
		short n = scanner.nextShort();
		for(short i=0;i<n;i++){
			short num = scanner.nextShort();
			Num numObj = null;
			if(numTimesMap.containsKey(num)){
				numObj = numTimesMap.get(num);
			}else{
				numObj = new Num();
			}
			numObj.num = num;
			numObj.times++;
			numTimesMap.put(num, numObj);
		}
		//排序输出
		List<Num> numList = new ArrayList<>(numTimesMap.values());
		Collections.sort(numList,new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				if(o1.times == o2.times){
					return o1.num-o2.num;
				}else{
					return o2.times-o1.times;
				}
			}
		});
		for(Num num:numList){
			System.out.println(num);
		}
	}

}
