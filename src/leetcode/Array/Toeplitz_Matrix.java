package leetcode.Array;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * 判断一个矩阵的对象线上的元素是否一样
 * <p>
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,2],
 * [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 */
public class Toeplitz_Matrix {
    class Solution {


        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (matrix[i][j] != matrix[i - 1][j - 1]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        //少m+n次循环并且少一个if无疑最佳
        public boolean isToeplitzMatrix_Most_Votes(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
                }
            }
            return true;
        }
    }
}
