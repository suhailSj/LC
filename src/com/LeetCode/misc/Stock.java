package com.LeetCode.misc;

public class Stock {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{6,1,3,2,4,7}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length ==0) {
                return 0;
            }
            int j =0;
            int profit=0;
            int max1 =0;
            int max2=0;
            for(int i =1; i<prices.length; i++) {
                int tmp = prices[i] - prices[j];
                if(tmp > 0) {
                    profit+=tmp;
                }else{
                    int tmp2 = max1;
                    max1 = Math.max(max1, profit);
                    if(tmp2 != max1){
                        max2 = tmp2;
                    }
                    profit =0;
                }
                j=i;
            }
            if(profit > 0){
                int tmp2 = max1;
                max1 = Math.max(max1, profit);
                if(tmp2 != max1){
                    max2 = tmp2;
                }
            }
            return max1+max2;
        }
    }
}
