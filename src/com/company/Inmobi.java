package com.company;

/**
 * created by suhail.jahangir on 29/09/20
 */

import java.util.*;

/**
 * Array - i<j<k
 * tuple exist such that a[i] <a[j] && a[j] > a[k]   && a[i] <a[k]
 * [2,8,3,5,4]
 * [8,4,2,5,3,]
 * [2,4,5,8,5,4,3]
 * [2,3,5,4,100]
 */
//            2
//        4        5
//    3       4   5      4
    // right  - 3  ->4 ->5->8
    //left     2->4 ->5->8
//public class Inmobi {
//
//    public boolean tupleExist(int[] arr) {
//        if(arr.length == 0){
//            return false;
//        }
//       Stack<Integer> rightStack = new Stack<>();
//       Stack<Integer> leftStack = new Stack<>();
//        rightStack.push(arr[arr.length-1]);
//        leftStack.push(arr[0]);
//       for(int i=arr.length-2; i>=0;i--){
//           if(rightStack.peek() < arr[i]){
//               rightStack.push(arr[i]);
//           }
//       }
//        for(int i=1; i<arr.length;i++){
//            if(leftStack.peek() < arr[i]){
//                leftStack.push(arr[i]);
//            }
//        }
//
//
//    }
//
//    class Index {
//        public int element;
//        public int position;
//    }

    //start n end time of meeting 2 - 100, , 40 -60, 102-400
    public class Inmobi {
        public static void main(String[] args) {
//            Meeting meeting = new Meeting();
//            List<Schedules> list = new ArrayList<>();
//            list.add(new Schedules(100,400));
//            list.add(new Schedules(2,100));
//            //list.add(new Schedules(40,60));
//            //list.add(new Schedules(100,400));
//            System.out.println(meeting.canAttend(list));
            Integer s = new Integer(0);

            if(s ==  0){
                System.out.println("opopop");
            }
        }
    public static class Meeting {


        public boolean canAttend(List<Schedules> list) {
            PriorityQueue<CustomClass> queue = new PriorityQueue<>((a,b) -> {
                if(a.time == b.time) {
                    if(a.isStart){
                        return 1;
                    } else if(b.isStart){
                        return -1;
                    }
                    return 0;
                }
                return a.time - b.time;
            });

            for(Schedules schedule : list){
                queue.add(new CustomClass(schedule.start, true));
                queue.add(new CustomClass(schedule.end, false));
            }
            int count =0;
            int max = 0;
            while(!queue.isEmpty()) {
               CustomClass tmp =  queue.remove();
               if(tmp.isStart) {
                   count ++;
               } else{
                   count --;
               }
               max = Math.max(max, count);
            }
            return true;
        }
        public  class CustomClass {
            public int time;
            public boolean isStart;
            public CustomClass(int time, boolean isStart){
                this.time = time;
                this.isStart = isStart;
            }
        }
    }
    public static class Schedules {
        public int start;
        public int end;
        public Schedules(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}




