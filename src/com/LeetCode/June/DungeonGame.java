package com.LeetCode.June;

public class DungeonGame {

    public static void main(String... a) {
        Solution sol = new Solution();
        //[[1,-3,3],[0,-2,0],[-3,-3,-3]]
        //[[-2,-3,3],[-5,-10,1],[10,30,-5]]
        System.out.println(sol.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }

    static class Solution {
        public int calculateMinimumHP(int[][] dungeon) {

            int[][] dp = new int[dungeon.length][dungeon[0].length];


            dp[0][0] = Math.max(1, 1-dungeon[0][0]);
            for(int i=1; i<dungeon.length; i++) {
                dp[i][0] = Math.max(dp[i-1][0]-dungeon[i][0], 1);

            }
            for(int i=1; i<dungeon[0].length; i++) {
                dp[0][i] = Math.max(dp[0][i-1] - dungeon[0][i], 1);
            }

            for(int i=1; i<dungeon.length; i++) {
                for(int j=1; j< dungeon[0].length; j++) {
                   int top = Math.max(dp[i-1][j] - dungeon[i][j], 1);
                   int left = Math.max(dp[i][j-1] - dungeon[i][j], 1);
                    dp[i][j] = Math.min(top, left);
                }
            }
            return dp[dungeon.length-1][dungeon[0].length-1];
        }
    }

//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for(int i=0; i<nums.length; i++){
//            if(i+2 < nums.length && nums[i] == nums[i+2]){
//                i=i+2;
//            }else {
//                return nums[i];
//            }
//        }
//    }
}
