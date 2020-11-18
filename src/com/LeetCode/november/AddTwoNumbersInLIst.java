package com.LeetCode.november;

import com.LeetCode.util.List.ListHelper;
import com.LeetCode.util.List.ListNode;

import java.util.Stack;

/**
 * created by suhail.jahangir on 07/11/20
 */
public class AddTwoNumbersInLIst {

    public static void main(String... a) {

        Solution solution = new Solution();

        System.out.println(solution.addTwoNumbers(ListHelper.createList(new int[]{7,2,4,3}), ListHelper.createList(new int[] {9})));
    }
    static class Solution {



        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> first = new Stack<>();
            Stack<Integer> second = new Stack<>();

            while (l1 != null && l2 != null) {
                first.push(l1.val);
                second.push(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null){
                first.push(l1.val);
                l1 = l1.next;
            }
            while(l2 !=null){
                second.push(l2.val);
                l2 = l2.next;
            }

            ListNode start = new ListNode();
            ListNode it = null;
            int val;
            int carry = 0;
            while(!first.isEmpty() && !second.isEmpty()){
                val = first.pop() +second.pop() +carry;

                if(val > 9){
                    carry =1;
                    val = val%10;
                }else{
                    carry =0;
                }
                ListNode curr = new ListNode(val);
                curr.next = it;
                it = curr;
            }
            while(!first.isEmpty()){
                val = first.pop() +carry;
                if(val > 9){
                    carry =1;
                    val = val%10;
                }else{
                    carry =0;
                }
                ListNode curr = new ListNode(val);
                curr.next = it;
                it = curr;
            }
            while(!second.isEmpty()){
                val = second.pop() +carry;
                if(val > 9){
                    carry =1;
                    val = val%10;
                }else{
                    carry =0;
                }
                ListNode curr = new ListNode(val);
                curr.next = it;
                it = curr;
            }
            if(carry == 1){
                ListNode curr = new ListNode(1);
                curr.next = it;
                it = curr;
            }
            return it;
        }
    }
}
