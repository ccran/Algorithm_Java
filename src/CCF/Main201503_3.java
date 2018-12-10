package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
	问题描述
　　有一类节日的日期并不是固定的，而是以“a月的第b个星期c”的形式定下来的，比如说母亲节就定为每年的五月的第二个星期日。
　　现在，给你a，b，c和y1, y2(1850 ≤ y1, y2 ≤ 2050)，希望你输出从公元y1年到公元y2年间的每年的a月的第b个星期c的日期。
　　提示：关于闰年的规则：年份是400的整数倍时是闰年，否则年份是4的倍数并且不是100的倍数时是闰年，其他年份都不是闰年。例如1900年就不是闰年，
        而2000年是闰年。
　　为了方便你推算，已知1850年1月1日是星期二。
	输入格式
　　输入包含恰好一行，有五个整数a, b, c, y1, y2。其中c=1, 2, ……, 6, 7分别表示星期一、二、……、六、日。
	输出格式
　　对于y1和y2之间的每一个年份，包括y1和y2，按照年份从小到大的顺序输出一行。
　　如果该年的a月第b个星期c确实存在，则以"yyyy/mm/dd"的格式输出，即输出四位数的年份，两位数的月份，两位数的日期，中间用斜杠“/”分隔，位数不足时前补零。
　　如果该年的a月第b个星期c并不存在，则输出"none"（不包含双引号)。
	样例输入
	5 2 7 2014 2015
	样例输出
	2014/05/11
	2015/05/10
	评测用例规模与约定
	　　所有评测用例都满足：1 ≤ a ≤ 12，1 ≤ b ≤ 5，1 ≤ c ≤ 7，1850 ≤ y1, y2 ≤ 2050。
 */
public class Main201503_3 {
	public static boolean commit = true;
	public static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static boolean isLeapYear(int year){
		if(year%400==0 || (year%4==0 && year%100!=0)){
			return true;
		}else{
			return false;
		}
	}

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
		// 输入数据 1850-01-01为星期二
		int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), y1 = scanner.nextInt(),
				y2 = scanner.nextInt();
		// 统计到y1年所经历时间
		int elapseDays = 0;
		for (int i = 1850; i < y1; i++) {
			if (isLeapYear(i)) {
				elapseDays += 366;
			} else {
				elapseDays += 365;
			}
		}
		// 遍历y1到y2，计算期间月份所经历天数
		for (int y = y1; y <= y2; y++) {
			boolean leapYear = isLeapYear(y);
			if(leapYear){
				months[1] = 29;
			}else{
				months[1] = 28;
			}
			//计算到月份a累计天数
			int tmp = elapseDays;
			for(int i=1;i<a;i++){
				tmp+=months[i-1];
			}
			//计算a月1号的星期
			int daysOfWeek = 2 + tmp % 7;
			if (daysOfWeek > 7) {
				daysOfWeek %= 7;
			}
			//假设今天星期c,第b个星期c
			int days = 1 + (b - 1) * 7;
			if (daysOfWeek < c) {
				days += (c - daysOfWeek);
			} else if (daysOfWeek > c) {
				days += (c + 7 - daysOfWeek);
			}
			if(days>months[a-1]){
				System.out.println("none");
			}else{
				System.out.printf("%04d/%02d/%02d\n",y,a,days);
			}
			//开启新的一年
			if (leapYear) {
				elapseDays += 366;
			} else {
				elapseDays += 365;
			}
		}
	}
}
