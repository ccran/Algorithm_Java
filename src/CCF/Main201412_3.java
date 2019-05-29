package CCF;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 问题描述
　　某股票交易所请你编写一个程序，根据开盘前客户提交的订单来确定某特定股票的开盘价和开盘成交量。
　　该程序的输入由很多行构成，每一行为一条记录，记录可能有以下几种：
　　1. buy p s 表示一个购买股票的买单，每手出价为p，购买股数为s。
　　2. sell p s 表示一个出售股票的卖单，每手出价为p，出售股数为s。
　　3. cancel i表示撤销第i行的记录。
　　如果开盘价为p0，则系统可以将所有出价至少为p0的买单和所有出价至多为p0的卖单进行匹配。因此，
此时的开盘成交量为出价至少为p0的买单的总股数和所有出价至多为p0的卖单的总股数之间的较小值。
　　你的程序需要确定一个开盘价，使得开盘成交量尽可能地大。如果有多个符合条件的开盘价，你的程序应当输出最高的那一个。
输入格式
　　输入数据有任意多行，每一行是一条记录。保证输入合法。股数为不超过10的8次的正整数，出价为精确到恰好小数点后两位的正实数，且不超过10000.00。
输出格式
　　你需要输出一行，包含两个数，以一个空格分隔。第一个数是开盘价，第二个是此开盘价下的成交量。开盘价需要精确到小数点后恰好两位。
样例输入
buy 9.25 100
buy 8.88 175
sell 9.00 1000
buy 9.00 400
sell 8.92 400
cancel 1
buy 100.00 50
样例输出
9.00 450
评测用例规模与约定
　　对于100%的数据，输入的行数不超过5000。
 */
public class Main201412_3 {
public static boolean commit = false;

	public static class Order{
		public boolean isBuy;
		public double price;
		public long num;//这里务必使用long
		
		public Order(boolean isBuy, double price, long num) {
			super();
			this.isBuy = isBuy;
			this.price = price;
			this.num = num;
		}
	}
	
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
		//行号-记录map
		Map<Integer,Order> lineOrderMap = new HashMap<>();
		List<Double> priceList = new ArrayList<>();
		int lineCnt = 0;
		while(scanner.hasNextLine()){
			++lineCnt;
			String line = scanner.nextLine();
			String[] word = line.split(" ");
			//cancel 移除对应行数
			if(word.length==2){
				lineOrderMap.remove(Integer.parseInt(word[1]));
			}
			//设置order
			else{
				boolean isBuy = false;
				if(word[0].equals("buy")){
					isBuy=true;
				}
				double price = Double.parseDouble(word[1]);
				lineOrderMap.put(lineCnt, new Order(isBuy,price
						,Long.parseLong(word[2])));
				priceList.add(price);
			}
		}
		//创建order列表并排序
		List<Order> orderList = new ArrayList<>(lineOrderMap.values());
		Collections.sort(priceList);
		long maxBuy = 0;
		double maxPrice = Double.MIN_VALUE;
		//遍历再次遍历order计算最大成交量
		for(double price:priceList){
			long sumBuy = 0,sumSell = 0;
			for(Order order:orderList){
				if(order.isBuy){
					if(order.price>=price){
						sumBuy+=order.num;
					}
				}else{
					if(order.price<=price){
						sumSell+=order.num;
					}
				}
			}
			//成交量
			long min = Math.min(sumSell, sumBuy);
			if(min>maxBuy){
				maxBuy = min;
				maxPrice = price;
			}else if(min==maxBuy){
				maxPrice = price;
			}
		}
		//输出结果
		System.out.printf("%.2f %d\n",maxPrice,maxBuy);
	}
}
