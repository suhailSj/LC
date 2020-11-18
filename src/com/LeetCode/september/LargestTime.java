package com.LeetCode.september;

import java.util.ArrayList;

/**
 * created by suhail.jahangir on 02/09/20
 */
public class LargestTime {

    public static void main(String... n){
        Solution sol = new Solution();
        sol.largestTimeFromDigits(new int[]{1,2,3,4});
    }

    static class Solution {
        public String largestTimeFromDigits(int[] arr) {
            ArrayList<String> list = new ArrayList<>();
            process("",list, 0, new boolean[4], arr);
            System.out.println(list);
            return "";
        }


        public void process(String s,  ArrayList<String> list, int number, boolean[] used, int[] arr){
            if(number < 0 || number > 4 || used[number]){
                return;
            }
            if(s.length() == 4){
                if(isValid(s)){
                    list.add(s);
                }
                return;
            }

            for(int i =0; i<4; i++){
                if(!used[i]){
                    process(s, list, i+1, used, arr);
                    used[i] = true;
                    process(s+arr[i], list, i+1, used, arr);
                }

            }
        }

        public boolean isValid(String s){
            int h = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(2,4));
            if(h < 24 && min <60){
                return true;
            }
            return false;
        }
    }
}
