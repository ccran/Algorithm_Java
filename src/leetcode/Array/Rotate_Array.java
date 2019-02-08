package leetcode.Array;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Rotate_Array {
    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k %= len;
            if (k == 0) return;
            int[] tmp = new int[k];

            for (int i = 0; i < k; i++) {
                tmp[i] = nums[len - k + i];
            }
            for (int i = len - k; i > 0; i--) {
                nums[i + k - 1] = nums[i - 1];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = tmp[i];
            }
        }
    }
}
