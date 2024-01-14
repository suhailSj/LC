package com.LeetCode.year2020.december;

/**
 * created by suhail.jahangir on 27/12/20
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 */
public class DecodeWays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("261105"));
    }
    static class Solution {
        public int numDecodings(String s) {
            if(s.length() ==0 || s.charAt(0) == '0'){
                return 0;
            }
            if(s.length() == 1){
                if(s.charAt(0) == '0'){
                    return 0;
                }
                return 1;
            }
            int num = (s.charAt(0) -'0') *10 + (s.charAt(1) - '0');
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            if(s.charAt(0) == '0' && s.charAt(1) == '0'){
                return 0;
            }
            if(s.charAt(1) == '0'){
                if(s.charAt(0) > '2'){
                    return 0;
                }
                dp[1] = 1;
            }
            else if(num <=26 && num >= 10){
                dp[1] = 2;
            } else{
                dp[1] = 1;
            }

            for(int i=2; i<s.length();i++){
                num = (s.charAt(i-1) -'0') *10 + (s.charAt(i) - '0');
                if(s.charAt(i) == '0'){
                    if(num > 26 || s.charAt(i-1) == '0'){
                        return 0;
                    }
                    dp[i] = dp[i-2];
                    dp[i-1] = 0;
                }
                else if(num <=26 && num >= 10){
                    dp[i] = dp[i-1] + dp[i-2] ;
                }
                else{
                    dp[i] = dp[i-1];
                }

            }
            return dp[s.length()-1];
        }
    }
}
