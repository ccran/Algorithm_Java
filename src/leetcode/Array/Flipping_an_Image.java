package leetcode.Array;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * 反转矩阵的每行 1变0 0变1
 */
public class Flipping_an_Image {
    class Solution {
        //1.未仔细审题，存在大量无意义工作，若对应位置不同则无需进行交换
        //2.对于0与1的互换，位操作无疑是最优解
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                if (A.length % 2 == 1) {
                    A[i][A.length / 2] = 1 - A[i][A.length / 2];
                }
                for (int j = 0; j < A.length / 2; j++) {
                    int tmp = A[i][j];
                    A[i][j] = A[i][A.length - j - 1] == 0 ? 1 : 0;
                    A[i][A.length - j - 1] = tmp == 0 ? 1 : 0;
                }
            }
            return A;
        }

        public int[][] flipAndInvertImage_Most_Votes(int[][] A) {
            int n = A.length;
            for (int[] row : A)
                for (int i = 0; i * 2 < n; i++)
                    if (row[i] == row[n - i - 1])
                        row[i] = row[n - i - 1] ^= 1;
            return A;
        }
    }
}
