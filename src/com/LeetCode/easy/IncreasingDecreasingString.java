package com.LeetCode.easy;

/**
 * created by suhail.jahangir on 22/09/20
 */
public class IncreasingDecreasingString {

    static class Solution {
        public String sortString(String s) {
            int[] arr = new int[26];
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            int count =0;

            while(true){
                count =0;
                for(int i=0; i<26; i++){
                    if(arr[i] > 0){
                        arr[i]--;
                        sb.append((char)(i+97));
                    }else{
                        count++;
                    }
                }
                if(count == 26){
                    break;
                }
                count =0;
                for(int i=25; i>=0; i--){
                    if(arr[i] > 0){
                        arr[i]--;
                        sb.append((char)(i+97));
                    }else{
                        count++;
                    }
                }
                if(count == 26){
                    break;
                }
            }
            return sb.toString();
        }
    }
}
