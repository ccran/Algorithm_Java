package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【问题描述】
 * <p>
 * 作为一个新的拼写检查程序开发团队的成员，您将编写一个模块，用已知的所有形式正确的词典来检查给定单词的正确性。
 * 如果字典中没有这个词，那么可以用下列操作中的一个来替换正确的单词（从字典中）：
 * 1. 从单词中删除一个字母；
 * 2. 用一个任意字母替换单词中的一个字母；
 * 3. 在单词中插入一个任意字母。
 * 你的任务是编写一个程序，为每个给定的单词找到字典中所有可能的替换。
 * <p>
 * 【输入形式】
 * <p>
 * 输入的第一部分包含所有字典中的词，每个单词占用一行，以一个单一字符“#”作为结束。所有单词都不相同，字典中至多1000个单词。
 * <p>
 * 接下来的部分包含所有需要进行检查的单词，同样每个单词占用一行。这部分也以一个单一字符“#”作为结束。至多有50个单词需要检查。
 * <p>
 * 在输入中所有的单词（字典中的和需要检查的）都仅由小写字母组成，每个最多包含15个字符。
 * <p>
 * 【输出形式】
 * <p>
 * 对于每个在输入中出现的单词，按照它们在输入的第二部分出现的顺序输出一行。如果该单词是正确的（也就是说它包含在字典中）
 * 则输出信息：“is correct”；如果该单词不正确，则首先输出该单词，然后输入符号':'（冒号），之后空一格，
 * 写出它所有可能的替代，以空格分隔。这些替代的单词按照它们在字典中（输入的第一部分）出现的顺序写出。
 * 如果没有可替代的单词，则在冒号后面直接输出换行。
 * <p>
 * 【样例输入】
 * <p>
 * i
 * is
 * has
 * have
 * be
 * my
 * more
 * contest
 * me
 * too
 * if
 * award
 * #
 * me
 * aware
 * m
 * contest
 * hav
 * oo
 * or
 * i
 * fi
 * mre
 * #
 * 【样例输出】
 * <p>
 * me is correct
 * aware: award
 * m: i my me
 * contest is correct
 * hav: has have
 * oo: too
 * or:
 * i is correct
 * fi: i
 * mre: more me
 */
public class Test13 {
    private static final boolean commit = true;

    public static boolean wordCanReplace(String checkedWord, String replacedWord) {
        int lengthDiff = replacedWord.length() - checkedWord.length();
        if (Math.abs(lengthDiff) > 1)
            return false;
        //标志长短字符串
        String shortStr, longStr;
        if (lengthDiff == 1) {
            longStr = replacedWord;
            shortStr = checkedWord;
        } else {
            longStr = checkedWord;
            shortStr = replacedWord;
        }
        //遍历判断两字符串
        int i = 0, j = 0, diffCnt = 0;
        while (i < longStr.length() && j < shortStr.length()) {
            //字符相同
            if (longStr.charAt(i) == shortStr.charAt(j)) {
                i++;
                j++;
            } else {
                //不同且为增删
                if (lengthDiff == 1 || lengthDiff == -1) {
                    i++;
                }
                //不同且为替换
                else {
                    i++;
                    j++;
                }
                diffCnt++;
            }
        }
        while (i < longStr.length()) {
            i++;
            diffCnt++;
        }
        while (j < shortStr.length()) {
            j++;
            diffCnt++;
        }
        if (diffCnt == 1)
            return true;
        else
            return false;
    }

    //获取可以替换的单词
    public static List<String> getReplacedList(List<String> dicList, String word) {
        List<String> res = new ArrayList<>();
        for (String dic : dicList) {
            if (wordCanReplace(word, dic)) {
                res.add(dic);
            }
        }
        return res;
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
        //输入字典
        List<String> dicList = new ArrayList<>();
        while (true) {
            String word = scanner.next();
            if (word.equals("#")) {
                break;
            } else {
                dicList.add(word);
            }
        }
        //输入检查单词
        while (true) {
            String word = scanner.next();
            if (word.equals("#")) {
                break;
            }
            if (dicList.contains(word)) {
                System.out.println(word + " is correct");
            } else {
                List<String> replacedStrList = getReplacedList(dicList, word);
                System.out.print(word + ":");
                for (String replacedStr : replacedStrList) {
                    System.out.print(" " + replacedStr);
                }
                System.out.println();
            }
        }
    }
}
