package leetcode_tags.Array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * 找到一个一维数组里面最多的连续1所计算的和的最大值
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 */
public class Max_Consecutive_Ones {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0, tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    tmp++;
                } else {
                    if (tmp > max) {
                        max = tmp;
                    }
                    tmp = 0;
                }
            }
            if (tmp != 0) {
                if (tmp > max) {
                    max = tmp;
                }
            }
            return max;
        }

        //简洁美
        public int findMaxConsecutiveOnes_most_votes(int[] nums) {
            int maxHere = 0, max = 0;
            for (int n : nums)
                max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
            return max;
        }
    }
}
