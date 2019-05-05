package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> m1 = new HashMap<>();
        Map<Character, String> m2 = new HashMap<>();
        String[] splitStr = str.split(" ");
        if (pattern.length() != splitStr.length)
            return false;
        for (int i = 0; i < splitStr.length; i++) {
            if (!m1.containsKey(splitStr[i]) && !m2.containsKey(pattern.charAt(i))) {
                m1.put(splitStr[i], pattern.charAt(i));
                m2.put(pattern.charAt(i), splitStr[i]);
            } else {
                if (m1.containsKey(splitStr[i]) &&
                        !m1.get(splitStr[i]).equals(pattern.charAt(i))) {
                    return false;
                }
                if (m2.containsKey(pattern.charAt(i)) &&
                        !m2.get(pattern.charAt(i)).equals(splitStr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //abba dog cat cat fish
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(map.put(1,10)!=map.put(2,10));
        System.out.println(map.put(1,11)!=map.put(3,11));
        System.out.println(map.put(1,1000));
    }
}
