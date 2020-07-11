package LeetCode.DP;

import java.util.*;
import java.util.stream.Collectors;

public class LargestDivisibleSubset {

    public static void main(String... a){
        Solution sol= new Solution();
       System.out.println(sol.largestDivisibleSubset(new int[]{3,4,6,8,12,16,32}));
    }
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            if(nums == null || nums.length==0){
                return new ArrayList<>();
            }
            if(nums.length == 1){
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                return list;
            }
            int[] ans = new int[nums.length];
            int max = 0;
            int len = nums.length;

            Arrays.sort(nums);
            ans[0] =1;
            Arrays.fill(ans, 1);
            int maxPos = 0;
            int index=0;
            for(int j=0; j<nums.length; j++){
                for(int i=0; i< j; i++){
                    if(nums[j] % nums[i] ==0){
                        ans[j] = Math.max(ans[j], ans[i]+1);
                        if(maxPos<ans[j]){
                            maxPos = ans[j];
                            index=j;
                        }
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i = index; i>=0; i--){
                if(ans[i] == maxPos && nums[index] % nums[i] ==0){
                    list.add(nums[i]);
                    maxPos--;
                }
            }
            return list;
        }
    }
}
