package com.LeetCode.misc;

import java.util.*;

public class LastStoneWeight {

    public static void main(String... a){

    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i: stones){
                queue.add(i);
            }
            queue.comparator().reversed();
            int max =0;
            int sec = 0;
            while(queue.size() >1){
                max = queue.remove();
                sec = queue.remove();

                if(max != sec){
                    queue.add(max-sec);
                }
            }
            if(queue.isEmpty()){
                return 0;
            }
            return queue.poll();
        }
    }
}
