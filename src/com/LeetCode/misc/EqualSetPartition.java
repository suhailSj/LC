package com.LeetCode.misc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * created by suhail.jahangir on 23/08/20
 */
public class EqualSetPartition {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
    }

    static class Solution {
        HashMap<Integer,Integer> map = new HashMap<>();
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if((sum&1) ==1){
                return false;
            }
            sum = sum/2;
            return process(0,sum,0,nums);
        }

        public boolean process(int curr, int finalSum, int index, int[] nums){
            if(curr > finalSum || index >= nums.length){
                return false;
            }
            if(curr == finalSum){
                return true;
            }
            if(map.getOrDefault(index,-1) == curr){
                return false;
            }else {
                map.put(index,curr);
            }
            return process(curr+nums[index], finalSum, index+1, nums) || process(curr,finalSum,index+1,nums);
        }

    }
}
