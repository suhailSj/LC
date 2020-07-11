//package LeetCode.May;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class CourseSchedule {
//
//
//    static class Solution {
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//
//            for(int i=0; i<prerequisites.length; i++){
//                ArrayList<Integer> list = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
//                list.add(prerequisites[i][0]);
//                map.put(prerequisites[i][1], list);
//            }
//        }
//    }
//}
