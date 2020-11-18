package com.LeetCode.June;



//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//Note:
//
//If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//All airports are represented by three capital letters (IATA code).
//You may assume all tickets form at least one valid itinerary.
//One must use all the tickets once and only once.

import java.util.*;

//Example 1:
//
//Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
//Example 2:
//
//Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//             But it is larger in lexical order.
//[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
public class RecontructItenary {
    public static void main(String... a){
        Solution sol = new Solution();
        List<String> li1 = Arrays.asList(new String[]{"JFK","KUL"});
        List<String> li2 = Arrays.asList(new String[]{"JFK","NRT"});
        List<String> li3 = Arrays.asList(new String[]{"NRT","JFK"});
        //List<String> li4 = Arrays.asList(new String[]{"LHR", "SFO"});
        List<List<String>> main = new ArrayList<>();
        main.add(li1);
        main.add(li2);
        main.add(li3);
        //main.add(li4);
        System.out.println(sol.findItinerary(main));
    }

    static class Solution {
        List<String> ans = new ArrayList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            HashMap<String, PriorityQueue<String>> map = new HashMap<>();
            for(List<String> li : tickets){
                if(map.containsKey(li.get(0))){
                    map.get(li.get(0)).add(li.get(1));
                } else{
                    PriorityQueue<String> queue = new PriorityQueue<>(Comparator.naturalOrder());
                    queue.add(li.get(1));
                    map.put(li.get(0), queue);
                }
            }
            System.out.println(map);
            process("JFK", map);
            return ans;
        }

        private int process(String str, HashMap<String, PriorityQueue<String>> map) {
            PriorityQueue<String> queue = map.get(str);
            if(map.isEmpty()){
                ans.add(str);
            }
            if(queue == null && !map.isEmpty()) {
                return -1;
            }
            if(queue == null) {
                return 1;
            }
            //boolean val = true;
            int val =0;
            while(true && !queue.isEmpty()) {
                String pr = queue.remove();
                ans.add(str);
                if(queue.isEmpty()){
                    map.remove(str);
                }
                val = process(pr, map);
                if(val == -1) {
                    ans.remove(str);
                } else if(val == 1){

                } else{
                    break;
                }
            }
            return val;

        }
    }
}
