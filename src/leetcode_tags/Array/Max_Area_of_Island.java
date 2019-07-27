package leetcode_tags.Array;

/**
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * 找到二维数组中水平垂直方向连续1的和的最大值,dfs问题
 * <p>
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 */
public class Max_Area_of_Island {
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int tmp = 0;
                        tmp = deepSearch(grid, i, j, tmp);
                        if (tmp > max)
                            max = tmp;
                    }
                }
            }
            return max;
        }

        public int deepSearch(int[][] grid, int i, int j, int max) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                max++;
                if (i + 1 < grid.length) {
                    max = deepSearch(grid, i + 1, j, max);
                }
                if (i - 1 >= 0) {
                    max = deepSearch(grid, i - 1, j, max);
                }
                if (j + 1 < grid[i].length) {
                    max = deepSearch(grid, i, j + 1, max);
                }
                if (j - 1 >= 0) {
                    max = deepSearch(grid, i, j - 1, max);
                }
            }
            return max;
        }

        public int maxAreaOfIsland_Most_Votes(int[][] grid) {
            int max_area = 0;
            for(int i = 0; i < grid.length; i++)
                for(int j = 0; j < grid[0].length; j++)
                    if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
            return max_area;
        }

        public int AreaOfIsland(int[][] grid, int i, int j){
            if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
                grid[i][j] = 0;
                return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid1 = {{0, 1}, {1, 1}};
        System.out.println(new Solution().maxAreaOfIsland(grid1));
    }
}
