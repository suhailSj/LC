//package com.LeetCode.DP;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class SellStock {
//
//    public static void main(String... p){
//        Solution sol = new Solution();
//        System.out.println(sol.maxProfit(new int[]{9,0,8}));
//    }
//
//    static class Solution {
//        public int maxProfit(int[] prices) {
//            int len = prices.length;
//            int tmp= 0;
//            Dummy[] dummy = new Dummy[len];
//            int max =0;
//            for(int i=0; i<len; i++) {
//                max =0;
//                for(int j=i+1; j<len; j++) {
//                    tmp = prices[j] - prices[i];
//                    if(tmp > max) {
//                        max = tmp;
//                        dummy[i] = new Dummy(i, j, max);
//                    }
//                }
//            }
//            Arrays.sort(dummy, Comparator.comparingInt(a -> a.val));
//            int ans =0;
//            Dummy profit1 = new Dummy(0,0,0);
//            Dummy profit2 =new Dummy(0,0,0);
//            for(Dummy d : dummy){
////                profit1 =
//            }
//        }
//
//        static class Dummy{
//            public int i;
//            public int j;
//            public int val;
//            public Dummy(int i, int j, int val) {
//                this.i = i;
//                this.j = j;
//                this.val = val;
//            }
//        }
//    }
//}
