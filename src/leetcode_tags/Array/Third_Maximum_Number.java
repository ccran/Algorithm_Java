package leetcode_tags.Array;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Third_Maximum_Number {
    class Solution {
        public int thirdMax(int[] nums) {
            long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
            for (int num : nums) {
                if (num >= first) {
                    if (first == Long.MIN_VALUE) {
                        first = num;
                    } else {
                        if (num != first) {
                            third = second;
                            second = first;
                            first = num;
                        }
                    }
                } else if (num >= second) {
                    if (second == Long.MIN_VALUE) {
                        second = num;
                    } else {
                        if (num != second) {
                            third = second;
                            second = num;
                        }
                    }
                } else if (num >= third) {
                    third = num;
                }

            }
            return (int) (third != Long.MIN_VALUE ? third : first);
        }
    }
}
