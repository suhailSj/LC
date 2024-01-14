package com.LeetCode.year2024.jan;

public class MedianInSortedArray {



    public static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            boolean isEven = false;
            if(len%2 == 0){
                isEven = true;
            }
            int llen = Math.max(nums1.length, nums2.length);
            int[] result = new int[len+1];
            int indexNum1 = 0;
            int indexNum2 = 0;
            for(int i=0; i < llen; i++) {
                if(indexNum1 < nums1.length && indexNum2 < nums2.length) {
                    result[i] = Math.min(nums1[indexNum1], nums2[indexNum2]);
                    if(nums1[indexNum1] > nums2[indexNum2]) {
                        indexNum2++;
                    } else {
                        indexNum1++;
                    }
                } else if(indexNum1 < nums1.length) {
                    result[i] = nums1[indexNum1];
                    indexNum1++;
                } else {
                    result[i] = nums2[indexNum2];
                    indexNum2++;
                }
                if(isEven && i == llen/2){
                    return (result[i] + result[i - 1]) /2.0;
                } else if (!isEven && i ==llen/2){
                    return result[i]*1.0;
                }
            }
            return 1.0;
        }
    }
}
