package com.LeetCode.July;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {


    static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            process(graph, new ArrayList<>(), 0);
            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        public void process(int[][] graph, List<Integer> list, int node){
            if(node == graph.length-1){
                result.add(list);
            }
            for(int i: graph[node]){
                List<Integer> l = new ArrayList(list);
                l.add(i);
                process(graph, l, i);
            }
        }
    }
}
