package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 1.日历问题 2000年1月1日是周六
 */
public class Test1 {
    private static final boolean commit = true;

    //星期英文
    public static final String[] DayOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"
            , "Thursday", "Friday"};
    //每个月天数
    public static final int[] DaysOfMonth = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    //判断是否为闰年,闰年2月为29天
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //返回逝去天数对应的字符串
    public static String getElapseDayString(int elapseDay) {
        /**
         * 计算星期
         */
        String engDay = DayOfWeek[elapseDay % 7];
        /**
         * 计算年月日
         */
        int startYear = 2000, startMonth = 1;
        //找到年份
        while (elapseDay >= 366) {
            if (isLeapYear(startYear++)) {
                elapseDay -= 366;
            } else {
                elapseDay -= 365;
            }
        }
        //根据年份对2月赋值
        if (isLeapYear(startYear)) {
            DaysOfMonth[1] = 29;
        } else {
            DaysOfMonth[1] = 28;
        }
        //找到月份
        while (elapseDay >= DaysOfMonth[startMonth - 1]) {
            elapseDay -= DaysOfMonth[startMonth - 1];
            startMonth++;
        }
        //判断是否正好走完最后一个月
        if (startMonth == 13) {
            startYear++;
            startMonth = 1;
        }
        //剩余则为过了天数,并从1号算起
        String year = String.valueOf(startYear), month = startMonth < 10 ? "0" + startMonth : String.valueOf(startMonth),
                day = elapseDay + 1 < 10 ? "0" + (elapseDay + 1) : String.valueOf(elapseDay + 1);
        return year + "-" + month + "-" + day + " " + engDay;
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
        //循环获取输入
        while (scanner.hasNext()) {
            int elapseDay = scanner.nextInt();
            if (elapseDay == -1) {
                break;
            } else {
                System.out.println(getElapseDayString(elapseDay));
            }
        }
    }
}
