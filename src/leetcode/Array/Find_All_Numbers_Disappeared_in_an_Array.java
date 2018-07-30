package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 * <p>
 * 找到数组中缺失的数字，数字以递增方式增长
 */
public class Find_All_Numbers_Disappeared_in_an_Array {
    static class Solution {
        //思路过于复杂
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }

        //该方法的核心在于对数字所对应位置的标记
        public List<Integer> findDisappearedNumbers_Most_Votes(int[] nums) {
            List<Integer> ret = new ArrayList<Integer>();
            //对相应位置进行标记
            for (int i = 0; i < nums.length; i++) {
                int val = Math.abs(nums[i]) - 1;
                if (nums[val] > 0) {
                    nums[val] = -nums[val];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
