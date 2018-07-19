package leetcode.Array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * 给2n个数的数组，两两组合，使两两组合的最小值之和最大。
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * 1.n is a positive integer, which is in the range of [1, 10000].
 * 2.All the integers in the array will be in the range of [-10000, 10000].
 *
 * 考虑n为1，array为a1,b1 不妨假设a1<=b1 则 Sm = min(a1,b1) = a1
 *  若n为2，array为a1,b1,a2,b2 不妨假设a1<=b1<=a2<=b2 则Sm = a1 + 除了b2 = a1 + a2
 */
public class Array_Partition_I {
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }
}
