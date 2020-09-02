package LeetCode.august;

import java.util.Arrays;

/**
 * created by suhail.jahangir on 26/08/20
 */
public class minCostOfTrip {


    public static void main(String... a){
        Solution s = new Solution();
        System.out.println(s.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }

    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            if(days.length == 0){
                return 0;
            }
            int[] dp = new int[396];
            dp[0] = 0;
            int j = 0;
            for(int i =31;i<396; i++){
                if(i-30 == days[j]){
                    j++;
                    int one = dp[i-1] + costs[0];
                    int week = dp[i-7] + costs[1];
                    int mon = dp[i-30] + costs[2];
                    dp[i] = Math.min(one,Math.min(week,mon));
                    if(j>=days.length){
                        return dp[i];
                    }
                } else{
                    dp[i] = dp[i-1];
                }
            }
            return dp[395];
        }
    }

}
