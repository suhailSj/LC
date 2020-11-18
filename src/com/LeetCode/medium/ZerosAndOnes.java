package com.LeetCode.medium;

/**
 * created by suhail.jahangir on 04/10/20
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 474. Ones and Zeroes
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class ZerosAndOnes {

    public static void main(String[] args) {

    }

    static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            PriorityQueue<StringProcessor> set = new PriorityQueue<StringProcessor>(Comparator.comparing(a -> a.str));
            for(String str: strs){
                StringProcessor stringProcessor = processString(str, m,n);
                if(stringProcessor != null){
                   set.add(stringProcessor);
                }
            }

            return 0;
        }

        private StringProcessor processString(String str, int m, int n) {
            int ones =0;
            int zeroes =0;
            for(char ch : str.toCharArray()){
                if(ch == '1'){
                    ones++;
                }else{
                    zeroes++;
                }
            }
            if(ones > m || zeroes > n){
                return null;
            }
            return new StringProcessor(str, zeroes,ones);
        }

        static class StringProcessor{
            public String str;
            public int zeroes;
            public int ones;
            public StringProcessor(String str, int zeroes, int ones) {
                this.str = str;
                this.zeroes = zeroes;
                this.ones = ones;
            }
        }
    }


}
