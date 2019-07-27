package leetcode_tags.Array;

import java.util.*;

/**
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Degree_of_an_Array {
    static class Solution {
        public static int findShortestSubArray_Most_Votes(int[] nums) {
            Map<Integer, int[]> map = new HashMap<>();
            //get every element info:times startPos endPos
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[]{1, i, i});
                } else {
                    int[] value = map.get(nums[i]);
                    value[0]++;
                    value[2] = i;
                }
            }
            // get res
            int res = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
            for (int[] values : map.values()) {
                if (values[0] > maxLength) {
                    maxLength = values[0];
                    res = values[2] - values[1] + 1;
                }
                else if (values[0] == maxLength) {
                    if (values[2] - values[1] + 1 < res) {
                        res = values[2] - values[1] + 1;
                    }
                }
            }
            return res;
        }

        public static int findShortestSubArray(int[] nums) {
            final int MAX = 50000;
            //count times
            int[] count = new int[MAX];
            for (int i = 0; i < nums.length; i++) {
                count[nums[i]]++;
            }
            //find max times
            int maxTimes = 0;
            for (int i = 0; i < MAX; i++) {
                if (count[i] > maxTimes) {
                    maxTimes = count[i];
                }
            }
            //add max times element
            List<Integer> maxTimesElements = new ArrayList<>();
            for (int i = 0; i < MAX; i++) {
                if (count[i] == maxTimes)
                    maxTimesElements.add(i);
            }
            //find minLength
            int minLength = Integer.MAX_VALUE;
            while (!maxTimesElements.isEmpty()) {
                int start = 0, end = nums.length - 1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == maxTimesElements.get(0)) {
                        start = i;
                        break;
                    }
                }
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] == maxTimesElements.get(0)) {
                        end = i;
                        break;
                    }
                }
                if (end - start < minLength) {
                    minLength = end - start + 1;
                }
                maxTimesElements.remove(0);
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }

        public static void main(String[] args) {
            System.out.println(findShortestSubArray_Most_Votes(new int[]{1, 2, 2, 3, 1, 4, 2}));
        }
    }
}
