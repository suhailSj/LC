package com.LeetCode.year2020.medium;

/**
 * created by suhail.jahangir on 21/02/21
 */
public class CoinChange2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[]{1,2,5}));
    }
    public static class Solution{
        public int change(int amount, int[] coins) {

            int[] dp = new int[amount + 1];
            dp[0] = 1;


            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }

            return dp[amount];

        }

    }
}
