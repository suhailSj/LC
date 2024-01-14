package com.LeetCode.year2020.June;

public class HIndex {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.hIndex(new int[]{0,1,3,10,15,20,45, 46, 47,48,49,60, 61}));
    }

    static class Solution {
        public int hIndex(int[] citations) {
            int start =0;
            int end = citations.length;
            int len = end;
            int mid=0;
            int probableAns = 0;
            while(start<= end){
                mid = start + (end-start)/2;
                if(citations[mid] > (len-mid)) {
                    end = mid-1;
                } else if(citations[mid] < (len - mid)){
                    start = mid+1;
                    probableAns = mid;
                }else {
                    return citations[mid] > citations[probableAns]? citations[mid] : citations[probableAns];
                }
            }
            return citations[probableAns];

        }
    }
}
