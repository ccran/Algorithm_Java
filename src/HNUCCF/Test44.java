package HNUCCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Maya历法 【问题描述】
 * 
 * 在学术休假期间，M.A. Ya教授在古老的Maya历法上有一个惊人的发现。从一个古老的令人棘手的信息中，教授发现Maya文明以365天为一年，
 * 称为Haab，包含19个月。前18个月每月有20天，月份名字为：pop、no、zip、zotz、tzec、xul、
 * yoxkin、mol、chen、yax、zac、ceh、mac、kankin、muan、pax、koyab、cumhu。
 * 每月的天数使用数字来表示，从0~19，而不是用名字。Haab的最后一个月叫做uayet，有5天，
 * 表示为0、1、2、3、4。玛雅人认为这个月是不吉利的，法院不开庭，贸易停止了，人们甚至停止清扫地板。
 * 
 * 出于宗教的目的，Maya人使用另外一套历法，叫做Tzolkin（冬青年）。一年被分为13个期间，
 * 每个期间20天。每天被表示为由数字和日期名表示的数对。使用20个名字：imix、ik、akbal、
 * kan、chicchan、cimi、manik、lamat、muluk、ok、chuen、eb、ben、ix、mem、cib、
 * caban、eznab、canac、ahau，以及13个数字，双循环使用。
 * 
 * 请注意，每一天都有一个明确的描述。例如，在年初的日子被描述如下：
 * 
 * 1 imix, 2 ik, 3 akbal, 4 kan, 5 chicchan, 6 cimi, 7 manik, 8 lamat, 9 muluk,
 * 10 ok, 11 chuen, 12 eb, 13 ben, 1 ix, 2 mem, 3 cib, 4 caban, 5 eznab, 6
 * canac, 7 ahau, 在下一个期间开始为 8 imix, 9 ik, 10 akbal . . .
 * 
 * 年份（包含Haab和Tzolkin)用数字0、1、...来表示，数字0是世界的开始。因此，第一天表示为：
 * 
 * Haab: 0. pop 0
 * 
 * Tzolkin: 1 imix 0
 * 
 * 请帮M.A.Ya教授写一个程序，将Haab日历转换为Tzolkin日历。
 * 
 * 【输入形式】
 * 
 * 在Haab中日期用以下形式表示：
 * 
 * NumberOfTheDay. Month Year
 * 
 * 输入文件的第一行包含文件中输入日期的数目。接下来的n行包含Haab日历格式的n个日期，年份小于5000。
 * 
 * 【输出形式】
 * 
 * Tzolkin日期用一下格式：
 * 
 * Number NameOfTheDay Year
 * 
 * 输出包括n行，按照与输入日期对应的顺序，输出tzolkin日历格式日期。
 * 
 * 【样例输入】
 * 
 * 3 10.zac 0 0.pop 0 10.zac 1995
 * 
 * 【样例输出】
 * 
 * 3 chuen 0 1 imix 0 9 cimi 2801
 */
public class Test44 {
	public static final boolean commit = true;
	// haab19个月份（天数从0-19 ，最后一月0-4）
	private static String[] haabMonths = { "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax",
			"zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet" };
	// tzolkin天数20 结合数字从1-13
	private static String[] tzolkinDays = { "imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk",
			"ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau" };

	public static void main(String[] args) {
		InputStream is = null;
		if (commit) {
			is = System.in;
		} else {
			try {
				is = new FileInputStream("F:\\in.txt");
			} catch (Exception e) {

			}
		}
		Scanner scanner = new Scanner(is);
		// 初始化monthmap
		Map<String, Integer> haabMonthMap = new HashMap<>();
		for (int i = 0; i < haabMonths.length; i++) {
			haabMonthMap.put(haabMonths[i], i + 1);
		}
		// 输入Haab数量
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			// 接收Haab日期
			String dayPointMonth = scanner.next();
			// 获取年月日
			int year = scanner.nextInt();
			String[] splitDayMonth = dayPointMonth.split("\\.");
			int day = Integer.parseInt(splitDayMonth[0]), month = haabMonthMap.get(splitDayMonth[1]);
			// 计算总天数
			int sumDay = year * 365 + (month - 1) * 20 + day;
			// 转换成Tzolkin形式
			// 计算年份以及剩余天数
			int y = sumDay / 260;
			sumDay -= y * 260;
			// 计算月份与日期
			int startNumber = 0, dateNameIndex = 0;
			while (sumDay >= 20) {
				startNumber = (startNumber + 20) % 13;
				sumDay -= 20;
			}
			dateNameIndex += sumDay;
			startNumber = (startNumber + sumDay) % 13 + 1;
			System.out.println(startNumber + " " + tzolkinDays[dateNameIndex] + " " + y);
		}
	}
}
