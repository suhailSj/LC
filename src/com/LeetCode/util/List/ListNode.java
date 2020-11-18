package com.LeetCode.util.List;

/**
 * created by suhail.jahangir on 28/09/20
 */
public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode() {}
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode n = this;
        sb.append("[");
        while(n!= null){
            sb.append(n.val);
            sb.append(",");
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }
}


