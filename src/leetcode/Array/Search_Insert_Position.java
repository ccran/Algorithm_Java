package leetcode.Array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Search_Insert_Position {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else if (nums[mid] > target) right = mid - 1;
                else break;
            }
            return nums[mid] == target ? mid : left;
        }
    }
}
