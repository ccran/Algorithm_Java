package leetcode.Array;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class Min_Cost_Climbing_Stairs {
    static class Solution {
        public static int minCostClimbingStairs(int[] cost) {
            if (cost.length == 2)
                return Math.min(cost[0], cost[1]);

            int res = 0, i = cost[1] <= cost[0] + cost[2] ? 1 : 0;
            while (i < cost.length) {
                res += cost[i];
                if (i + 2 < cost.length) {
                    if (cost[i + 1] >= cost[i + 2])
                        i += 2;
                    else
                        ++i;
                } else {
                    break;
                }
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(minCostClimbingStairs(new int[]{0,1,1,1}));
        }
    }
}
