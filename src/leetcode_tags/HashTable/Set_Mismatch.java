package leetcode_tags.HashTable;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class Set_Mismatch {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] res = new int[2];
            int[] cnt = new int[nums.length + 1];
            for (int num : nums) cnt[num]++;
            for (int i = 1; i <= nums.length; i++) {
                if (cnt[i] == 0) res[1] = i;
                if (cnt[i] == 2) res[0] = i;
            }
            return res;
        }

        public int[] findErrorNums_Best(int[] nums) {
            int[] res = new int[2];
            for (int num : nums) {
                if (nums[Math.abs(num) - 1] > 0) nums[Math.abs(num) - 1] *= -1;
                else res[0] = Math.abs(num);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) res[1] = i + 1;
            }
            return res;
        }
    }
}
