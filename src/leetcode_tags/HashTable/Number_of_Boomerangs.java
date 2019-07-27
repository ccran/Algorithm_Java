package leetcode_tags.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Number_of_Boomerangs {
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                Map<Integer, Integer> distanceCnt = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (j != i) {
                        int distance = getDistance(point, points[j]);
                        distanceCnt.put(distance, distanceCnt.getOrDefault(distance, 0) + 1);
                    }
                }
                for (int cnt : distanceCnt.values()) {
                    res += cnt * (cnt - 1);
                }
            }

            return res;
        }

        private int getDistance(int[] a, int[] b) {
            int x = a[0] - b[0], y = a[1] - b[1];
            return x * x + y * y;
        }
    }
}
