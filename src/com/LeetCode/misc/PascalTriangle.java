package com.LeetCode.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PascalTriangle {

    public static void main(String... a) {
        Solution s = new Solution();
        s.getRow(4);
    }






    public static class Solution {
        public void getRow(int rowIndex) {
            if(rowIndex == 1) {
                //return Arrays.asList(1,1);
            }
            if(rowIndex == 0) {
               // return Arrays.asList(1);
            }
            int[][] dp = new int[rowIndex+1][rowIndex+1];
            dp[0][0] = 1;
            dp[1][0] = 1;
            dp[1][1] = 1;
            fillRow(rowIndex, dp);
            System.out.println(Arrays.stream(dp[rowIndex]).boxed().collect(Collectors.toList()));

        }

        public void fillRow(int rowIndex, int[][] dp) {
            if(dp[rowIndex-1][0] == 0) {
                fillRow(rowIndex-1, dp);
            }
            dp[rowIndex][0] = 1;
            dp[rowIndex][rowIndex] = 1;
            for(int i=1; i< rowIndex; i++) {
                dp[rowIndex][i] = dp[rowIndex-1][i-1] + dp[rowIndex-1][i];
            }


        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        public int fib(int n) {
//            if(map.containsKey(Integer.valueOf(n))) {
//                return map.get(n);
//            }
//            int val = fib(n-1)+fib(n-2);
//            map.put(n, val);
//            if(returnVal == Double.NEGATIVE_INFINITY)
//            return val;
//        }
    }
}
