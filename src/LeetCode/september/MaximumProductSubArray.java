package LeetCode.september;

/**
 * created by suhail.jahangir on 12/09/20
 */

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubArray {
    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(new int[]{2,3,-3,0,4,3,-2,-2,-98}));
    }
   static class Solution {
        public int maxProduct(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            int[] positiveDp = new int[nums.length+1];
            // 2 -3 4 -5
            int[] a = new int[2];int j =0;
            int max = Integer.MIN_VALUE;
            max=Math.max(max, positiveDp[0]);
            int product = 1;
            boolean pure =true;
            int tmp =1;
            for(int i=1; i<nums.length; i++){
                product *=nums[i];
                if(nums[i] < 0){
                    if(pure)
                        a[j] = product;
                    else
                        a[j] = product/tmp;
                    product = 1;
                    j++;
                    if(j==2){
                        //max= Math.max(a[0]*a[1], max);
                        pure = false;
                        product = a[0]*a[1];
                        tmp = product;
                        a[0] = a[1];
                        j=1;
                    }
                }else if(nums[i] == 0){
                    j =0;product = 1;
                    pure = true;
                }
                max = Math.max(max, product);
            }
            return max;
        }
    }
}
