package leetcode_tags.Array;

import java.util.Arrays;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * <p>
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, t
 * hey both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * <p>
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange,
 * and ans[1] is the size of the candy bar that Bob must exchange.
 * <p>
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 * <p>
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 */
public class Fair_Candy_Swap {
    static class Solution {
        public static int[] fairCandySwap(int[] A, int[] B) {
            int sumA = 0, sumB = 0;
            for (int tmp : A)
                sumA += tmp;
            for (int tmp : B)
                sumB += tmp;
            int diff = (sumA - sumB) / 2;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i] - B[j] == diff) {
                        return new int[]{A[i], B[j]};
                    }
                }
            }
            return null;
        }

        public static void main(String[] args) {
            int[] res = fairCandySwap(new int[]{1,2},new int[]{2,3});
            System.out.println(Arrays.toString(res));
        }
    }
}
