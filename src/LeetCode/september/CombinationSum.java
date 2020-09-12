package LeetCode.september;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<Set<Integer>> combinationSum3(int k, int n) {
            int[] dp = new int[n+1];
            process(k, n, dp, new ArrayList<>(), 0);
            return ans;
        }

        public void process(int k, int n, int[] dp, ArrayList<Integer> list, int curr){
            if(list.size() == k){
                if(curr == n ){
                    ans.add(list);
                }
                return ;
            }

            for(int i =1; i<10; i++){

            }
        }
    }
}
