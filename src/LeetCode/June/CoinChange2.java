package LeetCode.June;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.change(18, new int[]{1,3,5}));
    }
    static class Solution {
        public int change(int amount, int[] coins) {

            int[] dp = new int[amount+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            int ans = process(amount,coins,dp);
            for(int i : dp){
                System.out.print(i+" ");
            }
            System.out.println("");
            return ans;
        }

        public int process(int amount, int[] coins,int[] dp){

            if(dp[amount] != -1){
                return dp[amount];
            }


            int min = Integer.MAX_VALUE;
            for(int i =0; i<coins.length; i++){
                if(amount - coins[i] >=0){
                    min = Math.min(min, process(amount - coins[i], coins, dp)+1);
                }

            }
            return dp[amount] = min;
        }
    }
}
