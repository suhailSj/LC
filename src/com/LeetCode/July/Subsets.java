package com.LeetCode.July;

import java.util.*;

public class Subsets {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.subsets(new int[]{1,2,3}));
    }


    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            int len = nums.length;
            int j =0;
            int k =0;

//            for(int i=0;i<len; i++) {
//                for(j=i; j<len; j++) {
//                    List<Integer> li = new ArrayList<>();
//                    for(k=0; k<j; k++) {
//                        li.add(nums[k]);
//                    }
//                    res.add(li);
//                }
//            }
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<1000; i++) {
                l.add(i);
            }
            System.out.println(l);
            process(nums, new ArrayList<>(),0);

            System.out.println(res1);
            return new ArrayList<>(res1);
        }
//        HashSet<String> res = new HashSet<>();
//        public void process(int[] nums, String lis, int i) {
//            if(i == nums.length){
//                res.add(lis);
//                return;
//            }
//            process(nums, lis, i+1);
//            process(nums, lis+","+nums[i], i+1);
//        }
        HashSet<List<Integer>> res1 = new HashSet<>();
        public void process(int[] nums, List<Integer> lis, int i) {
            if(i == nums.length){
                res1.add(lis);
                return;
            }
            process(nums, lis, i+1);
            List<Integer>  l = new ArrayList<>(lis);
            l.add(nums[i]);
            process(nums, l, i+1);
        }
    }

}
