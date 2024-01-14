package com.LeetCode.year2020.May;

import java.util.TreeMap;
import java.util.stream.Collectors;

public class CharacterSort {

    public static void main(String... a) {
        CharacterSort.Solution sol = new CharacterSort.Solution();
        sol.frequencySort("aaaaabbererefdghgdgdjh");
    }
    public static class Solution{
        public String frequencySort(String s) {
            int[] arr = new int[128];
            for(char ch : s.toCharArray()){
                arr[(int)ch]++;
            }
            TreeMap<Integer, Character> map = new TreeMap<>((a,b) -> a>b?-1:+1);
            for(int i=0; i<128; i++){
                if(arr[i] != 0){
                    map.put(arr[i], (char)i);
                }
            }

           return map.entrySet().stream()
                    .filter(entry -> entry.getKey()>0)
                    .map(entry -> {
                        char ch = entry.getValue();
                        StringBuilder sb = new StringBuilder();
                        for(int i =0; i<entry.getKey(); i++){
                            sb.append(ch);
                        }
                        return sb.toString();
                    }).collect(Collectors.joining());
        }
    }
}
