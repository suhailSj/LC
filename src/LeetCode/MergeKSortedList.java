package LeetCode;

import sun.awt.image.IntegerComponentRaster;

import javax.swing.tree.TreeNode;
import javax.transaction.TransactionRequiredException;
import java.util.LinkedList;
import java.util.TreeMap;

public class MergeKSortedList {
    public static void main(String... a) {
        Solution sol = new Solution();
        sol.mergeKLists(null);
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static class Solution{

        public ListNode mergeKLists(ListNode[] lists) {
//            ListNode head = null;
//            ListNode newList = null;
//            LinkedList<ListNode> list = new LinkedList<>();
//            for(ListNode node: lists){
//                list.add(node);
//            }
//            int minElement = Integer.MIN_VALUE;
//            ListNode node = null;
//            int count = 0;
//            while(!list.isEmpty()){
//                for(ListNode listNode: list) {
//                    if(listNode == null) {
//                        list.remove(listNode);
//                        continue;
//                    }
//                    if(minElement<listNode.val) {
//                        node = listNode;
//                        minElement = listNode.val;
//                    }
//                }
//                if(count == 0) {
//                    head = node;
//                    newList = node;
//                } else{
//                    newList.next = node;
//                }
//                count++;
//                list.remove(node);
//                list.add(node.next);
//            }
//            return head;
            ListNode head = new ListNode(0);
            ListNode current = head;
            TreeMap<Integer, ListNode> map= new TreeMap<>();
            for(ListNode listNode: lists) {
                map.put(listNode.val, listNode);
            }
            while(map.size() != 0) {
                TreeMap<Integer, ListNode> temp= new TreeMap<>();
                temp.putAll(map);
                for(ListNode l:temp.values()) {
                    current.next = l;
                    current = current.next;
                    map.remove(l);
                    if(l.next != null) {
                        map.put(l.next.val, l.next);
                    }
                }
            }
            return head.next;
        }

        public int strStr(String haystack, String needle) {

            for(int i=0; i<haystack.length()-needle.length(); i++) {
               int j=  haystack.indexOf(needle.charAt(0));
                j=  haystack.indexOf(needle.charAt(0), i);
               if(haystack.substring(j,needle.length()).equals(needle)) {
                   return j;
               }
            }
            return 0;
        }
    }
}
