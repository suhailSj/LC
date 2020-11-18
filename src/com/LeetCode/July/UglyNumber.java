package com.LeetCode.July;

import java.util.*;

public class UglyNumber {

    public static void main(String... a){

    }

    static class Solution {

        static class QueueWithoutDuplicate<E> extends PriorityQueue<E> {

            @Override
            public boolean offer(E e){
                boolean isAdded = false;
                if(!super.contains(e))
                {
                    isAdded = super.offer(e);
                }
                return isAdded;
            }
        }
        public int nthUglyNumber(int n) {
            if(n == 1) {
                return 1;
            }
            int i =1;
            PriorityQueue<Integer> queue =  new QueueWithoutDuplicate<Integer>();
            queue.add(2);
            queue.add(3);
            queue.add(5);
            while(!queue.isEmpty()) {
                i++;
                int in = queue.poll();
                if(i==n) {
                    return in ;
                }
                queue.offer(in*2);
                queue.add(in*3);
                queue.add(in*5);
            }
            return 0;
        }

    }
}



//
//
//
//package com.LeetCode.July;
//
//        import java.util.ArrayList;
//        import java.util.LinkedList;
//
//public class UglyNumber {
//
//    public static void main(String... a){
//
//    }
//
//    static class Solution {
//        public int nthUglyNumber(int n) {
//            if(n == 1) {
//                return 1;
//            }
//            ArrayList<Integer> finalList = new ArrayList<>();
//            int i =1;
//            finalList.add(2);
//            finalList.add(3);
//            finalList.add(5);
//            process(finalList, i, n);
//            return ans;
//        }
//        LinkedList<Integer> list1 = new LinkedList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
//        LinkedList<Integer> list3 = new LinkedList<>();
//        int ans = 0;
//
//        static class ListNode{
//            public ListNode next;
//            public int val;
//            public ListNode(int v){
//                this.val = v;
//            }
//            public ListNode(){
//
//            }
//        }
//        public void process(ArrayList<Integer> finalList, int i, int n) {
//
//            ListNode head1 = new ListNode();
//            ListNode head2= new ListNode();
//            ListNode head3= new ListNode();
//            ListNode list1 = head1;
//            ListNode list2 = head2;
//            ListNode list3 = head3;
//            for(int in:finalList) {
//                i++;
//                if(i==n) {
//                    ans = in;
//                    return;
//                }
//
//                list1.next = new ListNode(in*2);
//                list1 = list1.next;
//                list2.next = new ListNode(in*3);
//                list2 = list2.next;
//                list3.next = new ListNode(in*5);
//                list3 = list3.next;
//            }
//            finalList.clear();
//        }
//
//    }
//}
