package leetcode_tags.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * 找到出现次数大于总长度一半的元素
 */
public class Majority_Element {
    static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int times = map.getOrDefault(nums[i], 0);
                if (times + 1 > nums.length / 2) {
                    return nums[i];
                }
                map.put(nums[i], times + 1);
            }
            return 0;
        }

        // Moore voting algorithm
        // 摩尔投票，对于与自己不相同的进行减
        // 最后剩下的肯定是超半数的，clever!
        public int majorityElement3(int[] nums) {
            int count=0, ret = 0;
            for (int num: nums) {
                if (count==0)
                    ret = num;
                if (num!=ret)
                    count--;
                else
                    count++;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
