package com.LeetCode.medium;

/**
 * created by suhail.jahangir on 19/09/20
 */

import java.util.HashMap;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    static class Solution {
        public int numDecodings(String s) {
            if(s.length() == 0){
                return 0;
            }
            HashMap<Integer, Character> map = new HashMap<>();
            for(int i=97; i<123; i++){
                map.put(i-96, (char)i);
            }
            int distinct = 1;
            char[] arr = s.toCharArray();
            for(int i=1; i<s.length(); i++){
                if(Integer.parseInt(""+arr[i-1]+arr[i]) <=26){
                    distinct++;
                }
            }
            return distinct;
        }
    }
}
