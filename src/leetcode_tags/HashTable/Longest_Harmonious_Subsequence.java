package leetcode_tags.HashTable;

import java.util.Map;
import java.util.TreeMap;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class Longest_Harmonious_Subsequence {
    class Solution {

        public int findLHS(int[] nums) {
            //没必要排序,可用contain
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            boolean flag = true;
            int pre = 0, max = 0;
            for (int key : map.keySet()) {
                if (flag) {
                    flag = false;
                } else {
                    if (key - pre == 1) {
                        //大小比较可用Math.max方法
                        int val = map.get(key) + map.get(pre);
                        if (val > max) {
                            max = val;
                        }
                    }
                }
                pre = key;
            }
            return max;
        }
    }
}
