package com.LeetCode.year2020.august;

import java.util.HashSet;

/**
 * created by suhail.jahangir on 23/08/20
 */
public class numbersWithSameConsecutiveDifference {

    public static void main(String... a){
        Solution solution = new Solution();
        solution.numsSameConsecDiff(4,7);
    }

    static class Solution {
        HashSet<Integer> list = null;
        public int[] numsSameConsecDiff(int N, int K) {
            list = new HashSet<>();
            if(N==1){
                list.add(0);
            }
            for(int i =1; i<10; i++){
                dfs(N-1,i, K);
            }
            Integer[] arr = new Integer[list.size()];
            return list.stream().mapToInt(i->i).toArray();
        }

        private void dfs(int n, int i, int j) {
            if(n==0){
                list.add(i);
                return;
            }
            int last = i%10;
            if(last -j >=0){
                dfs(n-1, i*10+(last-j),j);
            }
            if(last+j<10){
                dfs(n-1, i*10+(last+j),j);
            }
        }
    }

}
