package leetcode.Array;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class Contains_Duplicate_II {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k < 0) return false;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (i - map.get(nums[i]) <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
}
