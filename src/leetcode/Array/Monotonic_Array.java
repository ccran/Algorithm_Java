package leetcode.Array;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 */

public class Monotonic_Array {
    static class Solution {
        public static boolean isMonotonic(int[] A) {
            if (A.length == 1 || A.length == 2)
                return true;
            int flag = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] < A[i] && flag == 0) flag = 1;
                else if (A[i - 1] > A[i] && flag == 0) flag = -1;

                if (flag == 1 && A[i - 1] > A[i]) return false;
                if (flag == -1 && A[i - 1] < A[i]) return false;
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(isMonotonic(new int[]{1,1,1}));
        }
    }
}
