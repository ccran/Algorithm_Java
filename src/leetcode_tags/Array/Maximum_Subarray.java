package leetcode_tags.Array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Maximum_Subarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0, max = Integer.MIN_VALUE;
            for (int num : nums) {
                sum += num;
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
