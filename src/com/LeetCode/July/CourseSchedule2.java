package com.LeetCode.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule2 {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findOrder(3, new int[][]{{1,0}, {1,2}, {0,1}})));
    }

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            res = new int[numCourses];
            for(int i=0; i<prerequisites.length; i++){
                ArrayList<Integer> list = map.getOrDefault(prerequisites[i][0], new ArrayList<>());
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
            boolean[] arr = new boolean[numCourses];
            if(map.size() != numCourses){
                for(int i=0;i< numCourses;i++){
                    if(map.get(i) == null){
                        res[gl++] = i;
                        arr[i] =true;
                    }
                }
            }else{
                return new int[0];
            }

            boolean[] cur = new boolean[numCourses];
            for(int i:map.keySet()){
                if(!arr[i]){
                    Arrays.fill(cur, false);
                    arr[i] = true;
                    //cur[i] = true;
                    if(!process(map,i,arr, cur)){
                        res = new int[0];
                        return res;
                    }
                }
            }

            return res;
        }
        int[] res ;
        int gl=0;
        ArrayList<Integer> r = new ArrayList<>();
        public boolean process(HashMap<Integer, ArrayList<Integer>> map, int course, boolean[] arr,boolean[] cur){
            List<Integer> li = map.get(course);
            if(li == null){
                res[gl++] =(course);
                return true;
            }
            if(cur[course]){
                res = new int[0];
                return false;
            }
            cur[course] = true;
            for(int i:li){

                if(!arr[i]){
                    arr[i] = true;
                    if(!process(map,i,arr, cur)){
                        return false;
                    }
                } else if(cur[i]){
                    res = new int[0];
                    return false;
                }
            }
            res[gl++]=(course);
            return true;
        }
    }
}













