package com.LeetCode.misc;

import java.util.Arrays;

public class LIS {

    public static void main(String... m){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int []{1,2,10,11, 12,4,5}));
    }

    public static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int dp[] = new int[nums.length];
            Math.max(1,2);

            int len = 0;
            for(int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }
}
