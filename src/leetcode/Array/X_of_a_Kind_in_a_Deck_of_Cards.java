package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * In a deck of cards, each card has an integer written on it.
 * <p>
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * <p>
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 * <p>
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 * <p>
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 * <p>
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 * <p>
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 * <p>
 * Note:
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class X_of_a_Kind_in_a_Deck_of_Cards {
    class Solution {
        public int gcd(int a, int b) {
            return b > 0 ? gcd(b, a % b) : a;
        }

        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
            int res = 0;
            for (int i : count.values()) res = gcd(i, res);
            return res > 1;
        }
    }
}
