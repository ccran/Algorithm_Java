package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main201509_2 {
public static boolean commit = false;
	
	public static boolean isLeapYear(short year){
		if(year%400==0 || (year%4==0 && year%100!=0)){
			return true;
		}
		return false;
	}
	
	public static short[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31}; 

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
		short year = scanner.nextShort(),day = scanner.nextShort();
		if(isLeapYear(year)){
			daysOfMonth[1] = 29;
		}
		int month = 0;
		while(day>=daysOfMonth[month]){
			day-=daysOfMonth[month++];
		}
		if(day==0){
			day = daysOfMonth[--month];
		}
		System.out.println(month+1);
		System.out.println(day);
	}
}
