package leetcode_tags.Array;

/**
 * In MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * <p>
 * 矩阵的重新构造
 * <p>
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 * fill it row by row by using the previous list.
 * <p>
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
public class Reshape_the_Matrix {
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int rows = nums.length, cols = nums[0].length;
            if (rows * cols != r * c) {
                return nums;
            } else {
                int[][] res = new int[r][c];
                int m = 0, n = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        res[m][n++] = nums[i][j];
                        if (n == c) {
                            ++m;
                            n = 0;
                        }
                    }
                }
                return res;
            }
        }

        //已知行列数，给一个从小到大的索引可以算出相应的矩阵位置，没有大量的if判断，可读性更强!
        public int[][] matrixReshape_most_votes(int[][] nums, int r, int c) {
            int n = nums.length, m = nums[0].length;
            if (r * c != n * m) return nums;
            int[][] res = new int[r][c];
            for (int i = 0; i < r * c; i++)
                res[i / c][i % c] = nums[i / m][i % m];
            return res;
        }
    }
}
