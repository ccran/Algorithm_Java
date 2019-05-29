package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * 
 * 给出一个字符串，请将其每个单词反转后输出。
 * 
 * 【输入形式】
 * 
 * 输入第一行为一个正整数N，表示测试用例数，接下来的N行，每行一个字符串。
 * 
 * 【输出形式】
 * 
 * 输出N行，每行对应一个反转后的字符串。
 * 
 * 【样例输入】
 * 
 * 3 
 * olleh !dlrow 
 * m'I morf .unh 
 * I ekil .tae 
 * 【样例输出】
 * 
 * hello world! 
 * I'm from hnu. 
 * I like eat.
 */
public class Test49_E {
	private static final boolean commit = true;

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
        int N = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<N;i++){
        	String[] sentence = scanner.nextLine().split(" ");
        	for(int j=0;j<sentence.length;j++){
        		if(j==0){
        			System.out.print(new StringBuilder(sentence[j]).reverse());
        		}else{
        			System.out.print(" "+new StringBuilder(sentence[j]).reverse());
        		}
        	}
        	System.out.println();
        }
    }
}
