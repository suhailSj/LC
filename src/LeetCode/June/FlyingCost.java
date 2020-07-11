package LeetCode.June;

import java.util.Arrays;

public class FlyingCost {

    public static void main(String... a) {
        //[30,200],[400,50],[30,20]]
        Solution sol = new Solution();
        int[][] cost = new int[][]{{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}};
        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
        System.out.println(sol.twoCitySchedCost(cost));
    }

    public static class Solution {
        public int twoCitySchedCost(int[][] costs) {

            int sum =0;
            int[] first = new int[costs.length/2];
            int[] second = new int[costs.length/2];
            for(int i=0; i<costs.length; i++) {
            }
            return sum;
        }
    }
}
