package LeetCode.June;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructQueue {

    public static void main(String... a) {
        Solution sol = new Solution();
        //[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
       Arrays.stream(sol.reconstructQueue(new int[][]{{7,0}, {4,4},{7,1},{5,0},{6,1},{5,2}})).forEach(e -> System.out.println("["+e[0]+","+e[1]+"]"));
    }
    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] -b[1]:b[0] - a[0]);
            LinkedList<int[]> list = new LinkedList<>();
            int[][] result = new int[people.length][2];
            for(int[] p: people) {
                addAtIndex(p[1], p, result);
            }
            return result;

        }

        private void addAtIndex(int i, int[] p, int[][] result) {
            if(result[i][0] ==0 && result[i][1] ==0){
                result[i][0] = p[0];
                result[i][1] = p[1];
            } else{
                int index =i;
                int[] tmp = p;
                while(index < result.length ) {
                    int[]tmp2 = result[index];
                    result[index] = tmp;
                    tmp = tmp2;
                    index++;
                }
            }
        }
    }
}
