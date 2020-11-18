package com.LeetCode.util.List;

/**
 * created by suhail.jahangir on 07/11/20
 */
public class ListHelper {

    public static ListNode createList(int[] arr) {
        ListNode node = new ListNode();
        ListNode start = node;
        for(int a:arr){
            node.next = new ListNode(a);
            node = node.next;
        }
        return start.next;
    }
}
