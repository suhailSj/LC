package com.LeetCode.year2020.october;

/**
 * created by suhail.jahangir on 03/10/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * a <= b
 * b - a == k
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Example 4:
 *
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 * Example 5:
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 */
public class KDiffPairsInArray {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findPairs(new int[]{3,1,4,1,5}, 2));
        System.out.println(sol.findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(sol.findPairs(new int[]{1,3,1,5,4}, 0));
        System.out.println(sol.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
        System.out.println(sol.findPairs(new int[]{-1,-2,-3}, 1));
    }
    static class Solution {
        public int findPairs(int[] nums, int k) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i =0; i<nums.length;i++) {
                List<Integer> l = map.getOrDefault(nums[i], new ArrayList<>());
                l.add(i);
                map.put(nums[i], l);
            }
            int count=0;

            HashSet<List<Integer>> set = new HashSet<>();
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i] - k)){
                    for(int j : map.get(nums[i] -k)){
                        if(j != i){
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[i]-k);
                            set.add(l);
                            break;
                        }
                    }
                }
            }
            return set.size();
        }
    }
}
