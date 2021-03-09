package com.LeetCode.medium;

/**
 * created by suhail.jahangir on 22/02/21
 */

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures extends Object {
    static class Solution {
        public int[] dailyTemperatures(int[] num) {
            int[] ans = new int[num.length];
            Stack<Dummy> stack = new Stack<>();
            int possibleAns = 0;
            for(int i= num.length-1;i>=0; i++) {
                possibleAns = 0;
                if (!stack.isEmpty()) {
                    possibleAns =1;
                    while(!stack.isEmpty() && stack.peek().val < num[i]){
                        Dummy temp = stack.pop();
                        possibleAns = temp.index - i +1;
                    }
                }
                ans[i] = possibleAns;
                stack.add(new Dummy(num[i], i));
            }
            return ans;
        }

        class Dummy{
            int val;
            int index;
            public Dummy(int val, int index) {
                this.index = index;
                this.val = val;
            }
        }
    }
}
