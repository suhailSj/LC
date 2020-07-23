package LeetCode.July;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

    public static void main(String... a){

    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i : nums){
                map.put(i, map.getOrDefault(i,0)+1);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
            queue.addAll(map.keySet());
            int[] result = new int[26];
            for(int i=0; i<k; i++) {
                result[i] = queue.remove();
            }
            return result;
        }
    }
}
