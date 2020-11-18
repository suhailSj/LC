package com.LeetCode.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * created by suhail.jahangir on 13/09/20
 */

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.combinationSum3(3, 9));
    }
    static class Solution {
        Set<Set<Integer>> ans = new HashSet<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] dp = new int[n+1];
            process(k, n, dp, new HashSet<Integer>(), 1, 0);
            return ans.stream().map(ArrayList::new).collect(Collectors.toList());
        }

        public void process(int k, int n, int[] dp, Set<Integer> list, int curr, int sum){
            if(sum == n && list.size() == k){
                ans.add(list);
                return;
            }

           if(curr > 9 || list.size() > k || sum >n){
               return;
           }
            process(k, n, dp, new HashSet<>(list), curr+1, sum);
           list.add(curr);
           process(k,n,dp, list, curr+1, sum + curr);



        }
    }
}
