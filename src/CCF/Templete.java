package CCF;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Templete {
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
	}
}
