package com.LeetCode.year2020.september;

import java.util.ArrayList;
import java.util.List;

/**
 * created by suhail.jahangir on 04/09/20
 */
public class PartitionLabels {

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.partitionLabels("zababcbacaqdefedehijhklij"));
    }
    static class Solution {
        public List<Integer> partitionLabels(String S) {
            ArrayList<Integer> ans = new ArrayList<>();
            int[] start = new int[26];
            int[] end = new int[26];
            //Arrays.fill(start,-1);
            fillArray(S, start, end);
            int len  = S.length();
            int max = 0;
            char ch = 'a';
            int lastIndex = 0;
            int counter = 0;
            char[] arr = S.toCharArray();
            for(int i=0;i<len; i++){
                ch = arr[i];
                lastIndex = end[ch-'a'];
//                if(lastIndex == 0 && max < i){
//                    ans.add(1);
//                }
                max  = Math.max(lastIndex, max);
                counter = i;
                while(i<max){
                    ch = arr[i];
                    lastIndex = end[ch-'a'];
                    max  = Math.max(lastIndex, max);
                    i++;
                }
                if(i-counter == 0){
                    ans.add(1);
                } else{
                    ans.add(i-counter);
                    i--;
                }


            }
            return ans;
        }

        private void fillArray(String S, int[] start, int[] end) {
            int i=0;
            for(char ch : S.toCharArray()){
                i++;
                if(start[ch-'a'] != 0){
                    end[ch-'a'] = i;
                } else{
                    start[ch-'a'] = i;
                }
            }
        }
    }
}
