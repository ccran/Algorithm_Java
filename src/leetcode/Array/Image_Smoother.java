package leetcode.Array;

/**
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell becomes
 * the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class Image_Smoother {
    static class Solution {
        public static int[][] imageSmoother(int[][] M) {
            int[][] res = new int[M.length][M[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    int count = 0, cell = 0;
                    for (int m = -1; m <= 1; m++) {
                        for (int n = -1; n <= 1; n++) {
                            int x = i + m, y = j + n;
                            if (x >= 0 && x < M.length && y >= 0 && y < M[0].length) {
                                cell++;
                                count += M[x][y];
                            }
                        }
                    }
                    System.out.println(count + ":" + cell);
                    res[i][j] = (int) Math.floor(count * 1.0 / cell);
                }
            }
            return res;
        }

        public static void main(String[] args) {
            int[][] res = imageSmoother(new int[][]{{1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}});
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.println(res[i][j]);
                }
            }
        }
    }
}
