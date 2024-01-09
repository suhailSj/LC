package com.LeetCode.year2024.jan;

import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

/**
 * created by suhail.jahangir on 20/08/20
 */
public class ShuffleArray {

    public static void main(String... a){
        int[] arr = new int[]{1,2,3};
        Solution sol = new Solution(arr);
        System.out.println(Arrays.toString(sol.shuffle()));
        System.out.println(Arrays.toString(sol.shuffle()));
        System.out.println(Arrays.toString(sol.reset()));
        System.out.println(Arrays.toString(sol.shuffle()));
    }

    public static class Solution {

        private int[] arrCopy;
        Random rand = new Random();

        // Generate a random number between 0 and 100

        private int[] arr;
        public Solution(int[] nums) {
            arr = nums;
            arrCopy = Arrays.copyOf(arr, arr.length);
        }

        public int[] reset() {
            arr = arrCopy;
            if(arr.length ==0){
                return arr;
            }
            return arrCopy;
        }

        public int[] shuffle() {
            if(arr.length == 0){
                return arr;
            }
            int k = rand.nextInt(arr.length);
            int tmp = 0;
            int num = 0; int z =0;
            for(int i = 0; i < arr.length; i++){
                if(k+i >= arr.length){
                    if(z == 0){
                        z =1;
                        num =0;
                    } else {
                        num ++;
                    }
                } else {
                    num = k+i;
                }
                tmp = arr[num];
                arr[num] = arr[i];
                arr[i] = tmp;
            }
            return arr;
        }
    }





}
