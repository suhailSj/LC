package com.LeetCode.year2020.september;

import java.util.ArrayList;
import java.util.List;

/**
 * created by suhail.jahangir on 24/09/20
 */
public class SequentialDigit {

    public static void main(String... a){
        Solution sol = new Solution();
        //System.out.println(sol.sequentialDigits(10, 2167899));
        System.out.println(sol.sequentialDigits(1000, 13000));
    }
    static class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            int lower = ("" + low).length();
            int higher = ("" + high).length();
            List<Integer> list = new ArrayList<>();
            for (int j = lower; j < higher + 1; j++) {
                int starting = 0;
                while (true) {
                    long num = 0;
                    starting++;
                    for (int i = 0; i < j; i++) {
                        if(starting+i >= 10){
                            num = Long.MAX_VALUE;
                            break;
                        }
                        num = num * 10 + (starting + i);
                    }
                    if (num >= low && num <= high) {
                        list.add((int)num);
                    }
                    if (num > high) {
                        break;
                    }
                }
            }
            return list;
        }
    }
}
