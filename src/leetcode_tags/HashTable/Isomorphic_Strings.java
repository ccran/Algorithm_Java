package leetcode_tags.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class Isomorphic_Strings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> m1 = new HashMap<>(), m2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i), value = t.charAt(i);
                if (m1.containsKey(key) && !m1.get(key).equals(value)) {
                    return false;
                }
                else if(m2.containsKey(value) && !m2.get(value).equals(key)){
                    return false;
                }
                else {
                    m1.put(key, value);
                    m2.put(value, key);
                }
            }
            return true;
        }
    }
}
