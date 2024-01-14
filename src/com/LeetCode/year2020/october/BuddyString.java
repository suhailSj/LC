package com.LeetCode.year2020.october;

/**
 * created by suhail.jahangir on 13/10/20
 */

/**
 * Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 */
public class BuddyString {

    static class Solution {
        public boolean buddyStrings(String A, String B) {
            if(A.length() != B.length()){
                return false;
            }
            int[] arr = new int[26];
            int[] arrb = new int[26];
            int mismatch = 0;
            for(int i =0; i<A.length(); i++){
                if(A.charAt(i) != B.charAt(i)){
                    mismatch++;
                }
                arr[A.charAt(i) -'a']++;
                arrb[B.charAt(i) -'a']++;
            }
            if(mismatch == 2){
                return true;
            }
            if(mismatch == 0){
                for(int i=0; i<26; i++){
                    if(arr[i] != arrb[i]){
                        return false;
                    }
                    if(arr[i] >=2){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
