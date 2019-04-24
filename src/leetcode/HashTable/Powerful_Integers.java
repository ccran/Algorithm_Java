package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 * <p>
 * Return a list of all powerful integers that have value less than or equal to bound.
 * <p>
 * You may return the answer in any order.  In your answer, each value should occur at most once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * Example 2:
 * <p>
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 */
public class Powerful_Integers {
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> mulSet = new HashSet<>();
            for (int i = 1; i < bound; i *= x) {
                for (int j = 1; i + j <= bound; j *= y) {
                    mulSet.add(i + j);
                    if (y == 1)
                        break;
                }
                if (x == 1)
                    break;
            }
            return new ArrayList<>(mulSet);
        }
    }
}
