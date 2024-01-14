package com.LeetCode.year2020.July;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] left = new int[len];
            left[0] = 1;
            int[] right = new int[len];
            right[len-1] = 1;
            for(int i=1; i<len;i++) {
                left[i] = nums[i-1] * left[i-1];
                right[len-1-i] = nums[len-i] * right[len-i];
            }
            System.out.println("right - "+Arrays.toString(right));
            System.out.println("kleft - "+Arrays.toString(left));
            int[] result = new int[len];
            for(int i=0; i<len; i++){
                result[i] = right[i] *left[i];
            }
            return result;
        }
    }
}
