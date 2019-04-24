package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection_of_Two_Arrays_II {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> arr = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
            for (int num : nums2) {
                int times = map.getOrDefault(num, 0);
                if (times > 0) {
                    arr.add(num);
                    map.put(num, times - 1);
                }
            }
            //to int[]
            int[] res = new int[arr.size()];
            for (int i = 0; i < res.length; i++) res[i] = arr.get(i);
            return res;
        }
    }
}
