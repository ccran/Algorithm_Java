package leetcode.HashTable;

import java.util.*;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class Uncommon_Words_from_Two_Sentences {
    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            List<String> res = new ArrayList<>();
            String[] aWord = A.split(" "), bWord = B.split(" ");
            Map<String, Integer> aMap = new HashMap<>(), bMap = new HashMap<>();
            for (String word : aWord) aMap.put(word, aMap.getOrDefault(word, 0) + 1);
            for (String word : bWord) bMap.put(word, bMap.getOrDefault(word, 0) + 1);
            for (String key : aMap.keySet()) {
                if (aMap.get(key) == 1 && !bMap.containsKey(key)) {
                    res.add(key);
                }
            }
            for (String key : bMap.keySet()) {
                if (bMap.get(key) == 1 && !aMap.containsKey(key)) {
                    res.add(key);
                }
            }
            return res.toArray(new String[res.size()]);
        }
    }
}
