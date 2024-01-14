package com.LeetCode.year2020.May;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestKPoints {
    public static void main(String... a) {

    }

    public static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<Dummy> list = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
            for(int i =0; i<points.length; i++) {
                int val = 0;
                for(int j=0;j<2;j++) {
                    val = val+ (points[i][j]*points[i][j]);
                }
                list.add(new Dummy(val, points[i]));
            }
            int[][] result = new int[K][2];
            for(int i=0;i<K;i++) {
                result[i]=list.remove().pair;
            }
            return result;
        }
        public static class Dummy{
            public int value;
            public int[] pair;
            public Dummy(int value, int[] pair) {
                this.value = value;
                this.pair = pair;
            }
        }
    }
}
