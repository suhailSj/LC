package com.LeetCode.easy;

/**
 * created by suhail.jahangir on 28/09/20
 */

/**
 *  Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

import com.LeetCode.util.List.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class PalindromeLinkedList {

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            if(fast.next == null){
                return true;
            }
            do{
                slow = slow.next;
                fast = fast.next.next;
            }while(fast != null && fast.next != null);

            fast = head;
            slow = reverse(slow);
            while(slow != fast ){
                if(slow.val != fast.val){
                    return false;
                }
            }
            return true;
        }

        private ListNode reverse(ListNode slow) {
            ListNode prev = null;
            ListNode curr = slow;
            ListNode tmp = null;
            while(curr != null){
                tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
        }
    }

}
