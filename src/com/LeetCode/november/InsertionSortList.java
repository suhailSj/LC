package com.LeetCode.november;

import com.LeetCode.util.List.ListNode;

/**
 * created by suhail.jahangir on 03/11/20
 */
public class InsertionSortList {

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode start = head;
            ListNode prev = head;
            ListNode curr = head.next;
            boolean m = false;
            ListNode tmp = head;
            ListNode temp = head;
            // [-1,5,3,4,0]
            while(curr != null){
                temp = curr.next;
                head = start;
                m = false;
                while(head != null && head != curr){
                    if(curr.val < head.val){
                        if(head == start){
                            start = curr;
                        }else{
                            prev.next = curr;
                        }
                        tmp.next = curr.next;
                        curr.next = head;
                        m = true;
                        break;
                    }
                    prev = head;
                    head = head.next;
                }
                if(!m)
                    tmp = curr;
                curr = temp;
            }
            return start;
        }
    }
}
