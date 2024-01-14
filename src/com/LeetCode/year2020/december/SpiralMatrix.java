package com.LeetCode.year2020.december;

/**
 * created by suhail.jahangir on 08/12/20
 */

import java.util.Arrays;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.generateMatrix(3)).forEach(e-> Arrays.stream(e).forEach( a -> System.out.println(" "+a)));
    }
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            for(int i=0;i<n/2; i++){
                process(ans, i, n);
            }
            if((n&1) ==1){
                ans[n/2][n/2] = ++count;
            }
            return ans;
        }
int count =0;
        private void process(int[][] ans, int curr, int n) {
            for(int i=curr; i<n-curr; i++){
                ans[curr][i] = ++count;
            }
            count--;
            for(int i=curr; i<n-curr; i++){
                ans[i][n-curr-1] = ++count;
            }
            count--;
            for(int i=n-curr-1; i>=curr; i--){
                ans[n-curr-1][i] = ++count;
            }
            count--;
            for(int i=n-curr-1; i>curr; i--){
                ans[i][curr] = ++count;
            }
        }
    }
}
