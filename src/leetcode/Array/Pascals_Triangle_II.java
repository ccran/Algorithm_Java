package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 */
public class Pascals_Triangle_II {
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                res.add(new ArrayList<>(i + 1));
                res.get(i).add(1);//first set to 1
                for (int j = 1; j < i; j++) {
                    res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
                if (i != 0) res.get(i).add(1);//last set to 1
            }
            return res.get(rowIndex);
        }

        public List<Integer> row(int rowIndex) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            if (rowIndex == 0) return res;
            for (int i = 1; i <= rowIndex; i++) {
                int before = res.get(0);
                for (int j = 1; j < i; j++) {
                    int sum = before + res.get(j);
                    before = res.get(j);
                    res.set(j, sum);
                }
                res.add(1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getRow(3);
    }
}
