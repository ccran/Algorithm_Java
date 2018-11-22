package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Templete {
	public static boolean commit = false;
	
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
	}
}
