package com.LeetCode.year2020.medium;

/**
 * created by suhail.jahangir on 05/10/20
 */

/**
 * 2 Keys Keyboard
 * Medium
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 *
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 *
 *
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 */
public class TwoKeysKeyboard {

    static class Solution {
        static boolean[] arr = new boolean[1001];
        static {
            for(int i =1; i<=1000/2; i++){
                isPrime(i);
            }
        }
        public int minSteps(int n) {
            if(!arr[n]){
                return n;
            }
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            int ans = 0;
            for(int i =2; i<=n/2; i++){
                if(!arr[i]){
                    if(n %i == 0){
                        ans = ans +i;
                    }
                }
            }
            return ans;
        }

        public static void isPrime(int i){
            if(arr[i]){
                return;
            }
            for(int j=i+i; j<=1000; j+=i){
                arr[j] = true;
            }
        }

    }
}
