package com.LeetCode.year2020.september;

/**
 * created by suhail.jahangir on 03/09/20
 */

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.print(sol.repeatedSubstringPattern("abababc"));
    }
    static class Solution {
        public boolean repeatedSubstringPattern(String str) {
            int n = str.length();

            for (int i = n / 2; i > 0; i--) {
                if (n % i == 0) {
                    int left = 0;
                    int right = i;

                    while (right < n && str.charAt(left++) == str.charAt(right)) right++;

                    if (right == n) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
