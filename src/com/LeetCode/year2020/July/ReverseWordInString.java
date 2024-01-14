package com.LeetCode.year2020.July;

public class ReverseWordInString {

    public static void main(String... a) {

        String s = "a good   example";
        String[] arr = s.trim().split(" ");
       // System.out.println(arr.length);
        //Arrays.stream(arr).forEach(System.out::println);
        Solution sol = new Solution();
        System.out.println(sol.reverseWords(s));
    }

    static class Solution {
        public String reverseWords(String s) {
            int len =s.length();
            s= s + " ";
           StringBuilder sb = new StringBuilder();
           String returnString = "";
            for(int i =0; i<=len;i++){
                char ch = s.charAt(i);
                if(ch == 32) {
                    returnString = sb.toString() + returnString;
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(ch);
                if(s.charAt(i+1) == 32){
                    sb.append(" ");
                }
            }
            return returnString.trim();
        }
    }
}
