package leetcode_tags.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * 卖股票，求最大收益，并且只有在卖完以后才能买
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    static class Solution {

        //若能在当天卖出当天购入
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) profit += prices[i + 1] - prices[i];
            }
            return profit;
        }

        //若无法再同一天买入卖出
        public int maxProfit_Votes(int[] prices) {
            int profit = 0, i = 0;
            while (i < prices.length) {
                // find next local minimum
                while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
                int min = prices[i]; // need increment to avoid infinite loop for "[1]"
                // find next local maximum
                while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
                profit += i < prices.length ? prices[i++] - min : 0;
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit_Votes(new int[]{1,2,3,4,5}));
    }
}
