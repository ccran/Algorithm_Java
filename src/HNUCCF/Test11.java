package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * Julius Caesar 生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，
 * 用于军队的消息传递。假设你是Caesar 军团中的一名军官，需要把Caesar 发送的消息破译出来、
 * 并提供给你的将军。消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换
 * （例如：消息原文中的每个字母A都分别替换成字母F），其他字符不 变，并且消息原文的所有字母都是大写的。
 * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 * <p>
 * 【输入形式】
 * <p>
 * 最多不超过100个数据集组成。每个数据集由3部分组成：起始行：START 密码消息：
 * 由1到200个字符组成一行，表示Caesar发出的一条消息结束行：END 在最后一个数据集之后，是另一行：ENDOFINPUT
 * <p>
 * 【输出形式】
 * <p>
 * 每个数据集对应一行，是Caesar 的原始消息。
 * <p>
 * 【样例输入】
 * <p>
 * START
 * NS BFW, JAJSYX TK NRUTWYFSHJ FWJ YMJ WJXZQY TK YWNANFQ HFZXJX
 * END
 * START
 * N BTZQI WFYMJW GJ KNWXY NS F QNYYQJ NGJWNFS ANQQFLJ YMFS XJHTSI NS WTRJ
 * END
 * START
 * IFSLJW PSTBX KZQQ BJQQ YMFY HFJXFW NX RTWJ IFSLJWTZX YMFS MJ
 * END
 * ENDOFINPUT
 * 【样例输出】
 * <p>
 * IN WAR, EVENTS OF IMPORTANCE ARE THE RESULT OF TRIVIAL CAUSES
 * I WOULD RATHER BE FIRST IN A LITTLE IBERIAN VILLAGE THAN SECOND IN ROME
 * DANGER KNOWS FULL WELL THAT CAESAR IS MORE DANGEROUS THAN HE
 */
public class Test11 {
    private static final boolean commit = true;

    //Caesar解密
    public static String caesarDecode(String encodeStr) {
        StringBuilder sb = new StringBuilder(encodeStr);
        for (int i = 0; i < sb.length(); i++) {
            char encodeCh = sb.charAt(i);
            if (Character.isAlphabetic(encodeCh)) {
                char decodeCh = (char) (encodeCh - 5);
                if (decodeCh < 'A') {
                    decodeCh = (char) ('Z' + (decodeCh - 'A' + 1));
                }
                sb.replace(i, i + 1, String.valueOf(decodeCh));
            }
        }
        return sb.toString();
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
        while (true) {
            String start = scanner.nextLine();
            if ("ENDOFINPUT".equals(start)) {
                break;
            }
            String line = scanner.nextLine();
            System.out.println(caesarDecode(line));
            //读取end
            scanner.nextLine();
        }
    }
}
