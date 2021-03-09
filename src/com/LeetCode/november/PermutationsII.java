package com.LeetCode.november;

/**
 * created by suhail.jahangir on 08/12/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,2,3,1}));
    }
    static class Solution {

        HashSet<List<Integer>> set =new HashSet<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            //process(nums, new boolean[nums.length], 0, new ArrayList<>(), 0);

            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            int previous = nums[0]+3;
            for(int i=0; i< nums.length; i++){
                if(previous != nums[i]){
                    used[i] = true;
                    process(nums, used, 0, new ArrayList<>(), i);
                    used[i] =false;
                }
                previous = nums[i];
            }
            return new ArrayList<>(set);
        }

        public void process(int[] nums, boolean[] used, int count, List<Integer> list, int curr){
            if(count == nums.length-1){
                set.add(list);
                return;
            }
//            if(used[curr] && count != 0){
//                return;
//            }
            if(count ==0){
                list.add(nums[curr]);
            }

            for(int i =0 ;i <nums.length; i++){
                  if(!used[i]){
                      boolean[] newArray = Arrays.copyOf(used, nums.length);
                      newArray[i] = true;
                      ArrayList<Integer> l = new ArrayList<>(list);
                      l.add(nums[i]);
                      process(nums, newArray, count+1, l, i);
                  }
                  //used[i] = false;
            }
            //used[curr] = false;
        }
    }
}
