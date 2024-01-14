package com.LeetCode.year2020.september;

/**
 * created by suhail.jahangir on 25/09/20
 */

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {

    static class Solution {
        public String largestNumber(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i:nums){
                list.add(i);
            }
            list.sort((a, b) -> ("" + b + a).compareTo("" + a + b));
            StringBuilder sb = new StringBuilder();
            for(int i: list){
                sb.append(i);
            }
            while(sb.length() >1){
                if(sb.charAt(0) == '0'){
                    sb.replace(0,1,"");
                }else{
                    break;
                }
            }
            return sb.toString();
        }

    }
}
