package LeetCode.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CheapestFlight {
    public static void main(String... a){
        Solution sol = new Solution();
        //n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        //src = 0, dst = 2, k = 0
        int[][] arr = new int[][]{{0,1,100}, {1,2,100}, {0,2,500}};
        System.out.println(sol.findCheapestPrice(3, arr, 0,2, 0));
    }

    static class Solution {
        public int ans = Integer.MAX_VALUE;
        public boolean changed = false;
        int[] minArr;
        boolean[] visited;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            HashMap<Integer, ArrayList<Cost>> map = new HashMap<>();
           // HashMap<Integer, Boolean> visited  = new HashMap<>();
            visited = new boolean[n];
            for(int[] arr: flights){
                ArrayList<Cost> list = map.getOrDefault(arr[0], new ArrayList<>());
                list.add(new Cost(arr[1], arr[2]));
                map.put(arr[0], list);

            }
            minArr = new int[n];
            Arrays.fill(minArr, Integer.MAX_VALUE);
            System.out.println(map);
            minArr[src] = process(src, dst, K, map, 0, visited);
            //Arrays.stream(minArr).forEach(System.out::print);
            //[[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
            System.out.println("---- "+minArr[src]);
            return changed?minArr[src]:-1;
        }

        public int process(int src, int dst, int k, HashMap<Integer, ArrayList<Cost>> map, int currentCost, boolean[] visited){
            if(k<0 || map.get(src) == null){
                return minArr[src];
            }
            visited[src] = true;
            for(Cost cost : map.get(src)){
                System.out.println("src : "+src + ", cost :"+cost + ", ans : "+ans);
                if(visited[cost.dest]){
                    continue;
                }
                cost.visited=true;
                if(dst == cost.dest && k>=0){
                    minArr[src] = Math.min(minArr[src], currentCost+cost.cost);

                    changed = true;
                } else{
                    Math.min(process(cost.dest, dst, k-1, map, currentCost+cost.cost, visited), minArr[src]);
                }
            }
            return minArr[src];
        }

        static class Cost{
            public int dest;
            public int cost;
            public boolean visited = false;
            public Cost(int dest, int cost){
                this.cost=cost;
                this.dest= dest;
            }
            public String toString(){
                return "[cost: "+this.cost+", dest: "+this.dest+ " ]";
            }
        }

        public String process(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            StringBuilder sb = new StringBuilder();
            for(char ch : s.toCharArray()) {
                if(map.containsKey(ch)) {
                    for(int i =0; i< map.get(ch); i++) {
                        sb.append(""+ch);
                    }
                }
                map.remove(ch);
            }
            return sb.toString();
        }
    }
}
