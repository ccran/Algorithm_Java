package leetcode.Array;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Plus_One {
    class Solution {
        public int[] plusOne(int[] digits) {
            digits[digits.length - 1] += 1;
            int carry = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
            int len = digits.length;
            if (carry != 0) len += 1;
            int[] res = new int[len];
            if (carry != 0) res[0] = carry;
            int start = carry == 0 ? 0 : 1;
            for (int i = 0; i < digits.length; i++) {
                res[start++] = digits[i];
            }
            return res;
        }
    }
}
