//package com.LeetCode.year2023.november;
//
///**
// * created by suhail.jahangir on 20/11/20
// */
//public class SearchInRotatedSortedArray {
//
//    public static void main(String[] args) {
//
//    }
////[2,5,6,8,0,1,2], target = 0
////[5,6,0,0,1,2], target = 0
//    static class Solution {
//        public boolean search(int[] nums, int target) {
//            int start = 0;
//            int end = nums.length -1;
//            int mid = 0;
//            while (start <=end){
//                mid = start + (end-start)/2;
//
//                if (nums[mid] == target) {
//                    return true;
//                }
//                if(nums[mid] > target) {
//                    if(nums[end] > target){
//                        start = mid+1;
//                    } else {
//                        end = mid - 1;
//                    }
//                }
//                if(nums[mid] < target) {
//                    if(nums[mid] < nums[end]){
//
//                    }
//                }
//            }
//        }
//    }
//}
