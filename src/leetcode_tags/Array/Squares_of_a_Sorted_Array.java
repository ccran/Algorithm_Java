package leetcode_tags.Array;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */

public class Squares_of_a_Sorted_Array {
    class Solution {

        public int[] sortedSquares(int[] A) {
            int len = A.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                A[i] *= A[i];
            }
            int l = 0, r = len - 1, cnt = len - 1;
            while (l < len && r >= 0 && l <= r) {
                if (A[l] > A[r]) {
                    res[cnt--] = A[l++];
                } else {
                    res[cnt--] = A[r--];
                }
            }
            return res;
        }
    }
}
