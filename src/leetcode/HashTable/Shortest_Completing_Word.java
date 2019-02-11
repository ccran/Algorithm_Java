package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * <p>
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class Shortest_Completing_Word {
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            Map<Character, Integer> licensePlateMap = new HashMap<>();
            for (int i = 0; i < licensePlate.length(); i++) {
                char ch = licensePlate.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    licensePlateMap.put(Character.toLowerCase(ch),
                            licensePlateMap.getOrDefault(Character.toLowerCase(ch), 0) + 1);
                }
            }
            int minLen = Integer.MAX_VALUE;
            String res = "";
            for (String word : words) {
                Map<Character, Integer> chCountMap = new HashMap<>();
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (Character.isLowerCase(ch)) {
                        chCountMap.put(Character.toLowerCase(ch),
                                chCountMap.getOrDefault(Character.toLowerCase(ch), 0) + 1);
                    }
                }
                boolean flag = true;
                for (Map.Entry<Character, Integer> entry : licensePlateMap.entrySet()) {
                    if (!(chCountMap.containsKey(entry.getKey())
                            && chCountMap.get(entry.getKey()) >= entry.getValue())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (word.length() < minLen) {
                        minLen = word.length();
                        res = word;
                    }
                }
            }
            return res;
        }
    }
}
