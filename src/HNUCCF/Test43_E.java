package HNUCCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 【问题描述】
 * 
 * 一级方程式F1锦标赛由一系列称为大奖赛的分站赛组成。每一场比赛的车手都根据他们的最后位置获得积分。
 * 只有前10名车手按以下顺序获得分数：25、18、15、12、10、8、6、4、2、1。在锦标赛结束时，得分最多的车手是冠军。
 * 如果有平分，则冠军是赢的最多的人（即排位第一）。如果还是平分，则选择得到排位第二最多的人，依此类推，直到没有更多的排位进行比较。
 * 
 * 去年又提出了另一个得分制度，但被否决了。其中冠军是赢得最多的。如果有平手，冠军是得分最多的。
 * 如果仍然存在平手，则按原来的得分制度进行，即比较第二、第三、第四、...排位的次数。
 * 
 * 在本赛季，你会得到所有比赛的结果，你将根据两个得分系统来分别确定冠军。数据保证两套系统都能得到唯一的冠军。
 * 
 * 【输入形式】
 * 
 * 第一行一个整数t（1<=t<=20），t是分站赛的场次数。之后是每个分站赛的最终排位情况，每个的第一行一个整数n(1<=n<=100)表示排位车手人数，之后n行按排位列出车手的名字，排位从第一到最后，车手的名字为长度不超过50的英文字符，大小写区分。
 * 【输出形式】、
 * 
 * 输出为两行，第一行为按照原始规则确定的冠军，第二行是按照可选规则确定的冠军。
 * 
 * 【样例输入】
 * 
 * 3 3 apple banana pear 2 pear banana 2 apple banana
 * 
 * 【样例输出】
 * 
 * banana apple
 */
public class Test43_E {
	private static final boolean commit = true;

	// 排名前10的得分
	private static final int[] score = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };
	private static final int MAX_RANK = 100;

	static class Score {
		int sumScore;// 总分
		int[] rankTime = new int[MAX_RANK];// 排名次数 最大为100
	}

	// 程序入口
	public static void main(String[] args) {
		InputStream inputStream = null;
		// 从文件流读取输入
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
		// 名称-分数map
		Map<String, Score> nameScoreMap = new HashMap<>();
		// 分站赛次数
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			// 比赛排名
			int n = scanner.nextInt();
			scanner.nextLine();
			for (int j = 0; j < n; j++) {
				String name = scanner.nextLine();
				if (!nameScoreMap.containsKey(name)) {
					nameScoreMap.put(name, new Score());
				}
				// 获取当前角色成绩
				Score currentScore = nameScoreMap.get(name);
				currentScore.sumScore += score[j];// 总成绩累加
				currentScore.rankTime[j]++;// 名次累加
				nameScoreMap.put(name, currentScore);
			}
		}
		// 结果排序
		List<Map.Entry<String, Score>> res = new ArrayList<>(nameScoreMap.entrySet());
		// 根据第一种得分制度从小到大排序
		Collections.sort(res, new Comparator<Map.Entry<String, Score>>() {
			@Override
			public int compare(Map.Entry<String, Score> o1, Map.Entry<String, Score> o2) {
				// 总分相同则根据名次赢得最多的排序
				if (o1.getValue().sumScore == o2.getValue().sumScore) {
					for (int i = 0; i < MAX_RANK; i++) {
						if (o1.getValue().rankTime[i] != o2.getValue().rankTime[i]) {
							return o1.getValue().rankTime[i] - o2.getValue().rankTime[i];
						}
					}
					return 0;
				}
				return o1.getValue().sumScore - o2.getValue().sumScore;
			}
		});
		System.out.println(res.get(res.size() - 1).getKey());
		// 根据第二种得分制度
		Collections.sort(res, new Comparator<Map.Entry<String, Score>>() {
			@Override
			public int compare(Map.Entry<String, Score> o1, Map.Entry<String, Score> o2) {
				// 第一名次数相同，则先根据得分，再根据名次排序
				if (o1.getValue().rankTime[0] == o2.getValue().rankTime[0]) {
					if (o1.getValue().sumScore == o2.getValue().sumScore) {
						//从第二个名次开始
						for (int i = 1; i < MAX_RANK; i++) {
							if (o1.getValue().rankTime[i] != o2.getValue().rankTime[i]) {
								return o1.getValue().rankTime[i] - o2.getValue().rankTime[i];
							}
						}
						return 0;
					}else{
						return o1.getValue().sumScore - o2.getValue().sumScore;
					}
				}
				return o1.getValue().rankTime[0] - o2.getValue().rankTime[0];
			}
		});
		System.out.println(res.get(res.size() - 1).getKey());
	}
}
