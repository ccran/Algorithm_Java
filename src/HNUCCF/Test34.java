package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 【问题描述】谷歌、百度等搜索引擎已经成为了互连网中不可或缺的一部分。在本题中，你的任务也是设计一个搜索论文的搜索引擎
 * ，当然，本题的要求比起实际的需求要少了许多。
 * 本题的输入将首先给出一系列的论文，对于每篇论文首先给出标题，然后给出它被引用的次数。然后会有一系列的搜索询问，
 * 询问标题中包含特定关键词的论文有哪些。
 * 每一个询问可能包含多个关键词，你需要找出标题包含所有关键词的论文。
 * “包含”必须是标题中有一个词正好是给定的关键词，不区分大小写。
 * 对每个询问，都按被引用的次数从多到少输出满足条件的论文的标题。如果有被引用的次数相同的论文，
 * 则按照论文在输入中的顺序排列，先给出的论文排在前面。
 * <p>
 * 【输入形式】输入包含多组数据。
 * 每组数据首先有一行包含一个整数N(1<=N<=1000)，表示论文的数目，N=0表示输入结束。
 * 每组论文的信息第一行是论文的标题，由字母（大小写均可）和空格组成，不超过10个词，每个词不超过20个字符，
 * 标题总共不超过250个字符。第二行是一个整数K(0<=K&lt;=108)，表示它被引用的次数。在论文信息结束以后，
 * 有一行包含一个整数M(1<=M<=100)，表示询问的数目。接下来有M行，每行是一个询问，由L(1<=L<=10)个空格分开的词构成，每个词不超过20个字符。
 * <p>
 * 【输出形式】对每个询问，按照题目给定的顺序输出满足条件的论文的标题；如果没有满足条件的论文，就不输出。
 * 在每组询问的输出之后输出一行“***”，在每组数据的输出之后输出一行“---”。
 * <p>
 * 【样例输入1】
 * <p>
 * 6
 * Finding the Shortest Path
 * 120
 * Finding the k Shortest Path
 * 80
 * Find Augmenting Path in General Graph
 * 80
 * Matching in Bipartite Graph
 * 200
 * Finding kth Shortest Path
 * 50
 * Graph Theory and its Applications
 * 40
 * 6
 * shortest path
 * k shortest path
 * graph
 * path
 * find
 * application
 * 0
 * <p>
 * 【样例输出1】
 * <p>
 * Finding the Shortest Path
 * Finding the k Shortest Path
 * Finding kth Shortest Path
 * ***
 * Finding the k Shortest Path
 * ***
 * Matching in Bipartite Graph
 * Find Augmenting Path in General Graph
 * Graph Theory and its Applications
 * ***
 * Finding the Shortest Path
 * Finding the k Shortest Path
 * Find Augmenting Path in General Graph
 * Finding kth Shortest Path
 * ***
 * Find Augmenting Path in General Graph
 * ***
 * <p>
 * ***
 * ---
 * <p>
 * 【样例输入2】
 * <p>
 * 1
 * Finding the Shortest Path
 * 120
 * 2
 * Path
 * <p>
 * Pat
 * 0
 * <p>
 * 【样例输出2】
 * <p>
 * Finding the Shortest Path
 * <p>
 * ***
 * <p>
 * ***
 * <p>
 * ---
 */
public class Test34 {
    private static final boolean commit = true;

    public static class Article implements Comparable<Article> {
        private String title;
        private int accessTimes;

        public Article(String title, int accessTimes) {
            this.title = title;
            this.accessTimes = accessTimes;
        }

        @Override
        public int compareTo(Article o) {
            return o.accessTimes - this.accessTimes;
        }
    }

    //根据关键字返回引用的文章列表
    public static List<Article> getArticleListByKeyword(List<Article> articleList, String keyword) {
        List<Article> res = new ArrayList<>();
        for (Article article : articleList) {
            String[] articleSplitArr = article.title.split(" ");
            String[] keyWordSplitArr = keyword.split(" ");
            boolean isFind = true;
            for (String keyWordSplit : keyWordSplitArr) {
                isFind = false;
                for (String articleSplit : articleSplitArr) {
                    if (keyWordSplit.equalsIgnoreCase(articleSplit)) {
                        isFind = true;
                    }
                }
                if (!isFind)
                    break;
            }
            if (isFind) {
                res.add(article);
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
        //循环获取输入
        while (true) {
            int articleNum = scanner.nextInt();
            if (articleNum == 0)
                break;
            scanner.nextLine();
            //输入引用文章
            List<Article> articleList = new ArrayList<>();
            for (int i = 0; i < articleNum; i++) {
                String title = scanner.nextLine();
                int accessTimes = scanner.nextInt();
                articleList.add(new Article(title, accessTimes));
                scanner.nextLine();
            }
            //输入查询关键字
            int keyWordNum = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < keyWordNum; i++) {
                String keyword = scanner.nextLine();
                List<Article> res = getArticleListByKeyword(articleList, keyword);
                if (!res.isEmpty()) {
                    Collections.sort(res);
                    for (Article article : res) {
                        System.out.println(article.title);
                    }
                }
                System.out.println("***");
            }
            System.out.println("---");
        }
    }
}
