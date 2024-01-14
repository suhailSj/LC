package com.LeetCode.year2020.october;

/**
 * created by suhail.jahangir on 02/10/20
 */

import java.util.*;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {

    static class Solution {
        HashSet<List<Integer>> ans = new HashSet<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Map<Integer, List<List<Integer>>> dp = new HashMap<>();
            dp.put(0, new ArrayList<>());
            process(candidates, target, dp, new ArrayList<>(), 0);

            return new ArrayList<>(ans);
        }

        public void process(int[] candidates, int target, Map<Integer, List<List<Integer>>> dp, ArrayList<Integer> list, int start){
            if(start > candidates.length){
                return;
            }
            if(target == 0) {
                ans.add(list);
                return;
            }else if(target <0){
                return ;
            }
            for(int k=start; k<candidates.length; k++){
                Integer i = candidates[k];
                list.add(i);
                process(candidates, target-i, dp, new ArrayList<>(list),start);

                list.remove(i);

            }
        }
    }
}
