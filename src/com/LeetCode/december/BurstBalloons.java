package com.LeetCode.december;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;

/**
 * created by suhail.jahangir on 14/12/20
 */
public class BurstBalloons {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3,1,5,8}));
    }
    static class Solution {
        public int maxCoins(int[] nums) {
            int[] arr = new int[nums.length+2];
            arr[0] = arr[nums.length+1] =1;
            System.arraycopy(nums, 0, arr, 1, nums.length);
            int[][] temp = new int[nums.length+2][nums.length+2];
            for(int[] a : temp){
                Arrays.fill(a, -1);
            }
            //HashMap<String, Integer> m = new HashMap<>();
            //return process(arr, 0, nums.length+1, m);
            return process(arr, 0, nums.length+1, temp);
        }
        private int process(int[] arr, int left, int right,int[][] temp) {
            int ans = 0;
            String key = left+"|"+right;
            if(temp[left][right] == -1){
                for(int i=left+1; i<right; i++){
                    int score = arr[left]*arr[i]*arr[right];
                    int leftAns = process(arr, left, i, temp);
                    int rightAns = process(arr, i, right,temp);
                    ans = Math.max(ans, score+leftAns+rightAns);

                }
                temp[left][right] = ans;
            }

            return temp[left][right];
        }
        private int process(int[] arr, int left, int right,HashMap<String, Integer> map) {
            int ans = 0;
            String key = left+"|"+right;
            if(!map.containsKey(key)){
                for(int i=left+1; i<right; i++){
                    int score = arr[left]*arr[i]*arr[right];
                    int leftAns = process(arr, left, i, map);
                    int rightAns = process(arr, i, right,map);
                    ans = Math.max(ans, score+leftAns+rightAns);

                }
                map.put(key, ans);
            }

            return map.get(key);
        }
    }
}
