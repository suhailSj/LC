package com.LeetCode.year2020.June;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{3,5}, 4));
    }
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, -8);
            dp[0] =0;
            return process(coins,amount,dp);
        }

        public int process(int[] coins, int amount, int[] dp){
            if(dp[amount] != -8){
                return dp[amount];
            }
            int min = Integer.MAX_VALUE;

            for(int i:coins){
                if(amount -i >=0){
                    min = Math.min(process(coins, amount-i, dp)+1, min);
                }
            }
            if(min == Integer.MAX_VALUE){
                return dp[amount] = -2;
            }
            return dp[amount] = min;

        }
    }
}
