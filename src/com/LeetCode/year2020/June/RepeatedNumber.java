package com.LeetCode.year2020.June;

import java.util.Arrays;

public class RepeatedNumber {

    public static void main(String... a) {
        Solution sol = new Solution();
        sol.findDuplicate(new int[]{1,2,3,4,5,6,2});
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
//            int sum = 0;
//            for(int i : nums){
//                sum +=i;
//            }
            int sum = Arrays.stream(nums).sum();
            int n = nums.length;
            int expectedSum = (n*(n-1))/2;
            System.out.println("sum " + sum);
            System.out.println("edxpectedSum " + expectedSum);
            return sum - expectedSum;
        }
    }
}
