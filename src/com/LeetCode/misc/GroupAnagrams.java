package com.LeetCode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String... a){

    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String, List<String>> map = new HashMap<>();
            int tmp =0;
            int[] arr = new int[26];
            ;
            for(String str: strs){
                Arrays.fill(arr, 0);
                for(char ch: str.toCharArray()) {
                    arr[ch-'a']++;
                }
                String st =  Arrays.toString(arr);
                List<String> l = map.getOrDefault(st, new ArrayList<>());
                l.add(str);
                map.put(st, l);
            }
            return new ArrayList<>(map.values());
        }
    }
}
