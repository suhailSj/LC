package com.LeetCode.year2020.october;

/**
 * created by suhail.jahangir on 04/10/20
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 * Example 1:
 *
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Example 2:
 *
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * Example 3:
 *
 * Input: intervals = [[0,10],[5,12]]
 * Output: 2
 * Example 4:
 *
 * Input: intervals = [[3,10],[4,10],[5,11]]
 * Output: 2
 */
public class RemoveCoveredInterval {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeCoveredIntervals(new int[][]{
                {3,10},
                {4,10},
                {5,11}
        }));
        System.out.println(sol.removeCoveredIntervals(new int[][]{
                {1,2},
                {1,4},
                {3,4}
        }));
        System.out.println(sol.removeCoveredIntervals(new int[][]{//[1,4],[3,6],[2,8]
                {1,4},
                {3,6},
                {2,8}
        }));
        System.out.println(sol.removeCoveredIntervals(new int[][]{//[1,4],[3,6],[2,8]
                {1,4},
                {2,3}
        }));
        System.out.println(sol.removeCoveredIntervals(new int[][]{
                {0,10},
                {5,12}
        }));
    }
    static class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            queue.addAll(Arrays.asList(intervals));
            int from = 0;
            int to = 0;
            int count = 0;
            while(!queue.isEmpty()){
                int[] interval = queue.remove();
                if(to < interval[0]){
                    from = interval[0];
                    to = interval[1];
                } else{
                    if(to >= interval[1]){
                        count++;
                    } else{
                        to = interval[1];
                    }
                }
            }
            return intervals.length-count;
        }
    }

}
