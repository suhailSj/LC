package com.LeetCode.year2020.medium;

/**
 * created by suhail.jahangir on 19/09/20
 */

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new
 */
public class MaxPointsInLine {

    public static void main(String... a){
        //not solved
        Solution sol = new Solution();
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        System.out.println(sol.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        System.out.println(sol.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
    }
    static class Solution {
        public int maxPoints(int[][] points) {
            double m = 0.0;
            HashMap<Double, Integer> map = new HashMap<>();
            double y2 =0;
            double y1 =0;
            double x1=0;
            double x2 = 0;
//            for(int i=0;i<points.length;i++){
//                for(int j=i+1; j<points.length; j++){
//                    x1 = points[i][0];
//                    y1 = points[i][1];
//
//                    x2 = points[j][0];
//                    y2 = points[j][1];
//                    if(x2-x1 != 0){
//                        m = (y2-y1)/(x2-x1);
//                        map.put(m, map.getOrDefault(m,0)+1);
//                    }
//                }
//            }
           return map.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        }
    }
}
