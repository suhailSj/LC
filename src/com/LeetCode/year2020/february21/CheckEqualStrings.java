package com.LeetCode.year2020.february21;

/**
 * created by suhail.jahangir on 10/02/21
 */

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 */
public class CheckEqualStrings {

    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb = new StringBuilder();
            String s = String.join("", word1);
            String s2 = String.join("", word2);
            return s.equals(s2);
        }
    }
}
