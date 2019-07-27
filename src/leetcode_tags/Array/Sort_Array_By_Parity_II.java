package leetcode_tags.Array;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class Sort_Array_By_Parity_II {
    static class Solution {
        //not the best
        public static int[] sortArrayByParityII(int[] A) {
            int[] res = new int[A.length];
            int even = 0, odd = 1;
            for (int i = 0; i < A.length; i++) {
                //even
                if (A[i] % 2 == 0) {
                    res[even] = A[i];
                    even += 2;
                }
                //odd
                else {
                    res[odd] = A[i];
                    odd += 2;
                }
            }
            return res;
        }
    }
}
