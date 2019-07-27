package leetcode_tags.Array;

/**
 * We have two special characters. The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * <p>
 * 检测最后一个字符是否由1bit组成
 */
public class bit_and_2bit_Characters {
    static class Solution {
        //只要检测最后一位是否成单即可
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            while (i < bits.length - 1) {
                if (bits[i] == 1) {
                    i += 2;
                } else {
                    i++;
                }
            }
            if (i == bits.length - 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
