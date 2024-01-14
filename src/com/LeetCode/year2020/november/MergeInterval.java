package com.LeetCode.year2020.november;

/**
 * created by suhail.jahangir on 19/11/20
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeInterval {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals == null || intervals.length == 0){
                return new int[][]{};
            }
            Arrays.sort(intervals, (a,b) -> {
                if(a[0]!=b[0]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            ArrayList<int[]> list = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            for(int i = 1; i<intervals.length; i++){
                if(end >= intervals[i][0]){
                    end  = Math.max(end, intervals[i][1]);
                    continue;
                }
                //MyClass interval = new MyClass(start, end);
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            end = Math.max(end, intervals[intervals.length-1][1]);
            list.add(new int[]{start, end});
            int[][] result = new int[list.size()][2];
            int i=0;
            // for(MyClass myClass : list){
            //     result[i][0] = myClass.start;
            //     result[i][1] = myClass.end;
            //     i++;
            // }
            list.toArray(new int[list.size()][2]);
            return result;
        }

        static class MyClass{
            public int start;
            public int end;

            public MyClass(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }
}
