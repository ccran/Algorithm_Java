package leetcode_tags.HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Find_All_Anagrams_in_a_String {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return res;
            int[] chpCnt = new int[26], chsCnt = new int[26];
            for (char ch : p.toCharArray()) chpCnt[ch - 'a']++;
            for (int i = 0; i < p.length(); i++) chsCnt[s.charAt(i) - 'a']++;
            if (contain(chsCnt, chpCnt)) res.add(0);
            for (int i = 1; i <= s.length() - p.length(); i++) {
                chsCnt[s.charAt(i - 1) - 'a']--;
                chsCnt[s.charAt(i + p.length() - 1) - 'a']++;
                if (contain(chsCnt, chpCnt)) res.add(i);
            }
            return res;
        }

        boolean contain(int[] chsCnt, int[] chpCnt) {
            for (int i = 0; i < chsCnt.length; i++) {
                if (chpCnt[i] != 0) {
                    if (chsCnt[i] < chpCnt[i]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public List<Integer> findAnagrams_Most_Votes(String s, String p) {
            List<Integer> list = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
            int[] hash = new int[256]; //character hash
            //record each character in p to hash
            for (char c : p.toCharArray()) {
                hash[c]++;
            }
            //two points, initialize count to p's length
            int left = 0, right = 0, count = p.length();
            while (right < s.length()) {
                //move right everytime, if the character exists in p's hash, decrease the count
                //current hash value >= 1 means the character is existing in p
                if (hash[s.charAt(right++)]-- >= 1) count--;

                //when the count is down to 0, means we found the right anagram
                //then add window's left to result list
                if (count == 0) list.add(left);

                //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
                //++ to reset the hash because we kicked out the left
                //only increase the count if the character is in p
                //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
                if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams_Most_Votes("cbaebabacd","abc");
    }
}
