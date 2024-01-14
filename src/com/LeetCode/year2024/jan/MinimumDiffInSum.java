package com.LeetCode.year2024.jan;

import com.LeetCode.misc.PascalTriangle;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDiffInSum {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumDifference(new int[]{20,9,5,8,3,10,15,19,2}));
    }

    public static class Solution {
        //20,9, 5,  8,  3,   10,   15,19,2
        //          34  22   16   18             isum
        //          42  37   44    36       lsum
        public long minimumDifference(int[] nums) {
            int len = nums.length;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int[] initialSum = new int[nums.length];
            int[] lastSum = new int[nums.length];

            int isum = 0;
            int lsum = 0;
            int iter=0;
            for(iter=0; iter<len/3; iter++){
                isum =isum+nums[iter];
                lsum =lsum+nums[len-1-iter];
                maxHeap.add(nums[iter]);
                minHeap.add(nums[len-1-iter]);

            }
            initialSum[iter] = isum;
            initialSum[iter-1] = isum;
            lastSum[len-1-iter] = lsum;

            for(int i = len/3; i< 2*len/3; i++){
                initialSum[i] = Math.min(isum, initialSum[i-1]);
                int maxElement = maxHeap.poll();
                isum = isum - maxElement + nums[i];
                maxHeap.add(nums[i]);


                int minElement = minHeap.poll();
                lsum = lsum-minElement+nums[len-1-i];
                lastSum[len-1-i] = Math.max(lsum, lastSum[len-i]);
                minHeap.add(nums[len-1-i]);
            }

            int minResult = Integer.MAX_VALUE;
            for(int i = len/3; i< 2*len/3+1; i++) {
                System.out.println("isum : "+ i + " = "+ initialSum[i]);
                System.out.println("lsum : "+ i + " = "+ lastSum[i]);
                minResult = Math.min(minResult, (initialSum[i]-lastSum[i]));
            }

            return minResult;
        }
    }
}
