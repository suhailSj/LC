package com.LeetCode.May;

import java.util.HashMap;

public class MajorityElement {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int half = 1+ (nums.length-1)/2;
            for(int num : nums){
                if(map.containsKey(num)) {
                    int val = map.get(num)+1;
                    map.put(num, val);
                    if(val>= half){
                        return num;
                    }
                } else{
                    map.put(num,1);
                }
            }
            return 0;
        }
    }
}
