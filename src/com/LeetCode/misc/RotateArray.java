package com.LeetCode.misc;

/**
 * created by suhail.jahangir on 26/09/20
 */

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * It's guaranteed that nums[i] fits in a 32 bit-signed integer.
 * k >= 0
 */
public class RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length == 0) {
                return;
            }
            k = k % nums.length;
            if (k == 0) {
                return;
            }
            reverse(nums, 0,nums.length);
            reverse(nums, 0,k);
            reverse(nums, k,nums.length);
        }

        public void reverse(int[] arr, int start, int end){
            int j =start;
            int tmp = 0;

            for(int i=0; i<end-start;i++){
                tmp = arr[i+j];
                arr[i+j] = arr[end-j];
                arr[end-j] = tmp;
            }
        }
    }
}
