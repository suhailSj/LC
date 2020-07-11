package LeetCode.June;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompleteCourse {

    public static void main(String... a) {

    }

    static class Solution {
        int global=0;
        int sem =0;
        public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for(int i=0; i<dependencies.length; i++){
                ArrayList<Integer> list = map.getOrDefault(dependencies[i][1], new ArrayList<>());
                list.add(dependencies[i][0]);
                map.put(dependencies[i][1], list);
            }
            process(k, n, map, dependencies[0][1]);
            return sem;
        }

        public void process(int k, int n, HashMap<Integer, ArrayList<Integer>> map, int currentCourse) {
            List<Integer> li = map.getOrDefault(currentCourse, null);
            if(li != null) {
                for(int i : li) {
                    process(k, n, map, i );
                }
                map.remove(currentCourse);
            } else{
                global++;
                if(global == k) {
                    sem++;
                    global =0;
                }
            }

//            for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
//                entry.
//            }
        }
    }
}
