package com.LeetCode.hard;

import com.sun.tools.classfile.ConstantPool;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * created by suhail.jahangir on 21/02/21
 */
public class CountOfSmalllerNNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSmaller(new int[]{5,2,6,1}));
        System.out.println(solution.countSmaller(new int[]{-1,-1}));
        System.out.println(solution.countSmaller(new int[]{-1}));
    }
    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            // 5. 2. 6  1
            //    2.     1 0             0

            Stack<Integer> stack = new Stack<>();
            //stack.add(0);
            stack.push(nums[0]);
            for(int i=1; i<nums.length; i++) {
                if(stack.peek() > nums[i]){
                    stack.push(nums[i]);
                }
            }
            stack.push(0);
            Collections.reverse(stack);
            List<Integer> count = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                if(nums[i] > stack.peek()) {
                    count.add(stack.peek());
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        count.add(0);
                        stack.push(0);
                    } else
                        count.add(stack.peek());
                }
            }
            return count;
        }
    }
}
