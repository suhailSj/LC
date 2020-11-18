package com.LeetCode;

/**
 * created by suhail.jahangir on 03/09/20
 */
public class ReplaceWithGreatest {

    public static void main(String... a){

    }

    static class Solution {
        public int[] replaceElements(int[] arr) {
            if(arr.length == 0){
                return arr;
            }
            int great = arr[arr.length-1];
            arr[arr.length-1] = -1;
            for(int i=arr.length-2; i>=0; i--){
                if(arr[i] < great){
                    arr[i] = great;
                }else{
                    great = arr[i];
                    arr[i] = -1;
                }
            }
            return arr;
        }
    }
}
