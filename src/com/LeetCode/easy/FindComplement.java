package com.LeetCode.easy;

/**
 * created by suhail.jahangir on 03/10/20
 */
public class FindComplement {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findComplement(78));
    }
    static class Solution {
        public int findComplement(int num) {
            int ans = 0;
            int tmp = 0;
            int multiplier = 1;
            String s = Integer.toString(num, 2);
            while(num >0){
                tmp = num&1;
                ans = ans + (tmp^1)*multiplier;
                multiplier *= 2;
                num = num>>>1;
            }
            return ans;
        }
    }
}
