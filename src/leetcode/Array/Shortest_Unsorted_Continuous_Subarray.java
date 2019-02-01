package leetcode.Array;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class Shortest_Unsorted_Continuous_Subarray {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < nums.length - 1 && nums[l + 1] >= nums[l]) l++;
            while (r > 0 && nums[r] >= nums[r - 1]) r--;
            if (l >= r) return 0;
            int min = nums[l], max = nums[r];
            for (int i = l; i <= r; i++) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
            while (l >= 0 && nums[l] > min) l--;
            while (r < nums.length && nums[r] < max) r++;
            return r - l - 1;
        }
    }
}
