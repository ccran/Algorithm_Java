package leetcode_tags.HashTable;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode_tags"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 */
public class Verifying_an_Alien_Dictionary {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] alpOrder = new int[26];
            for (int i = 0; i < order.length(); i++) alpOrder[order.charAt(i) - 'a'] = i;
            for (int i = 1; i < words.length; i++) {
                String before = words[i - 1], current = words[i];
                boolean same = true;
                for (int j = 0; j < before.length() && j < current.length(); j++) {
                    if (alpOrder[before.charAt(j) - 'a'] > alpOrder[current.charAt(j) - 'a'])
                        return false;
                    else if (alpOrder[before.charAt(j) - 'a'] < alpOrder[current.charAt(j) - 'a']) {
                        same = false;
                        break;
                    }
                }
                if (same && before.length() > current.length()) return false;
            }
            return true;
        }
    }
}
