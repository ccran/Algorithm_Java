package leetcode_tags.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class Pascals_Triangle {
    static class Solution {
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows >= 1) {
                res.add(Arrays.asList(1));
            }
            if (numRows >= 2) {
                res.add(Arrays.asList(1, 1));
            }
            if (numRows > 2) {
                for (int i = 3; i <= numRows; i++) {
                    Integer[] item = new Integer[i];
                    for (int j = 0; j < i; j++) {
                        if (j == 0 || j == i - 1) {
                            item[j] = 1;
                        } else {
                            int ope1 = res.get(i - 2).get(j - 1), ope2 = res.get(i - 2).get(j);
                            item[j] = ope1 + ope2;
                        }
                    }
                    res.add(Arrays.asList(item));
                }
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(generate(5));
        }
    }
}
