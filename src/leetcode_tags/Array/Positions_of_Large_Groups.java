package leetcode_tags.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.
 * We would like the starting and ending positions of every large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 */
public class Positions_of_Large_Groups {
    static class Solution {
        public static List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> res = new ArrayList<>();
            char pre = S.charAt(0);
            int start = 0;
            for (int i = 1; i < S.length(); i++) {
                char ch = S.charAt(i);
                if (ch != pre) {
                    if (i - start >= 3) {
                        res.add(Arrays.asList(start, i - 1));
                    }
                    start = i;
                    pre = ch;
                }
            }
            if (S.length() - start >= 3) {
                res.add(Arrays.asList(start, S.length() - 1));
            }
            return res;
        }

        public static void main(String[] args) {
            List<List<Integer>> res = largeGroupPositions("abbxxxxzzy");
            for (List<Integer> item : res) {
                System.out.println(item);
            }
        }
    }
}
