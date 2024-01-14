package com.LeetCode.year2020.June;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(100, 100));
    }

    static class Solution {
        long[] dp ;
        public int uniquePaths(int m, int n) {

            int right = m-1;
            int down = n-1;
            if(right == 0 || down == 0) {
                return 0;
            }
            dp = new long[right+down+1];
            dp[0] =1;
            dp[1] =1;
            dp[right+down] = find(right+down);
            Arrays.stream(dp).forEach(System.out::println);
            return (int)((dp[right+down])/(dp[right] * dp[down]));
        }

        public long find(int x) {
            if(dp[x] != 0) {
                return dp[x];
            }
            if(x ==1) {
                return 1;
            }
            dp[x] =x * find(x-1);
            return dp[x];
        }
    }
}
