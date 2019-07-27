package leetcode_tags.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 * <p>
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 * <p>
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class Maximize_Distance_to_Closest_Person {
    static class Solution {
        public int maxDistToClosest(int[] seats) {
            List<Integer> seatsIndex = new ArrayList<>();
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    seatsIndex.add(i);
                }
            }
            int first = seatsIndex.get(0), last = seatsIndex.get(seatsIndex.size() - 1);
            int max = first > seats.length - 1 - last ? first : seats.length - 1 - last;

            for (int i = 0; i < seatsIndex.size() - 1; i++) {
                int nowSeat = seatsIndex.get(i), nextSeat = seatsIndex.get(i + 1);
                int distance = (nextSeat - nowSeat) / 2;
                if (distance > max) {
                    max = distance;
                }
            }
            return max;
        }

        public int maxDistToClosest_(int[] seats) {
            int i, j, res = 0, n = seats.length;
            for (i = 0, j = 0; j < n; j++) {
                if (seats[j] == 1) {
                    if (i == 0) res = Math.max(res, j);
                    else res = Math.max(res, (j - i + 1) / 2);
                    i = j + 1;
                }
            }
            res = Math.max(res, n - i);
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxDistToClosest_(new int[]{1, 0, 0, 0, 1, 0, 1});
    }
}
