package leetcode.Array;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class Magic_Squares_In_Grid {
    static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int cnt = 0;
            for (int x = 0; x < grid.length - 2; x++) {
                for (int y = 0; y < grid[x].length - 2; y++) {

                    boolean[] visited = new boolean[9];
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (grid[x + m][y + n] >= 1 && grid[x + m][y + n] <= 9)
                                visited[grid[x + m][y + n] - 1] = true;
                        }
                    }
                    boolean onetonine = true;
                    for (int k = 0; k < 9; k++) {
                        if (!visited[k]) {
                            onetonine = false;
                            break;
                        }
                    }
                    if (!onetonine)
                        continue;
                    if ((grid[x][y] + grid[x][y + 1] + grid[x][y + 2]) != 15) continue;
                    if ((grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2]) != 15) continue;
                    if ((grid[x][y] + grid[x + 1][y] + grid[x + 2][y]) != 15) continue;
                    if ((grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2]) != 15) continue;
                    if ((grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2]) != 15) continue;
                    if ((grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y]) != 15) continue;
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}});
    }
}
