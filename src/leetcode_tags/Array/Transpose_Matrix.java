package leetcode_tags.Array;

/**
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * 矩阵的转置，水题，没什么好说的。
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class Transpose_Matrix {
    class Solution {
        public int[][] transpose(int[][] A) {
            int[][] result = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    result[j][i] = A[i][j];
                }
            }
            return result;
        }
    }
}
