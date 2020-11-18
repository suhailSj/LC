package com.company;

import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

//Array with numbers , find largest palindrome number
//[1, 232, 54545, 999991]
public class ArvindInternet {

    public static void main(String... a){
        ArvindInternet ar = new ArvindInternet();
        System.out.println(ar.getLargestPalindrome(new int[]{1, 232, 54545, 999991}));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ar.printTree(root);

    }
    public int getLargestPalindrome(int[] arr) {
        if(arr.length ==0){
            return 0;
        }
        OptionalInt largetst = Arrays.stream(arr)
                .filter(this::checkForPalindrome)
                .max();
//        int max = 0;
//        for(int i =0; i< arr.length; i++){
//            if(checkForPalindrome(arr[i])){
//               max =  Math.max(arr[i], max);
//            }
//        }
//        return max;
        if(largetst.isPresent()){
            return largetst.getAsInt();
        }
        return 0;
    }

    private boolean checkForPalindrome(int e) {
        String str = ""+e;
        int len = str.length();
        for(int i =0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }



    //linked list, n node of one linked list got merged with seciond one
    // 3--> 6 --> 9
    //10 --> 50 --> 30   -------- 1000
    //3--> 6 --> 9 --> 50 --> 30 -----5
    static class Node {
        public int val;
        public Node next;

    }
    private Node getIntersection(Node first, Node second) {
        HashSet<Node> set = new HashSet<>();

        while(first != null){
            set.add(first);
            first = first.next;
        }
        while(second != null){
            if(set.contains(second)){
                return second;
            }
            second = second.next;
        }
        return null;
    }
//            1
//        2       3
//    4     5   6    7
//
    //1 2, 3,, 7,6,5,4

    public void printTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> tmpStack = new Stack<>();
        boolean leftToRight = false;
        while(!stack.isEmpty() && stack.peek() != null) {

            while(!stack.isEmpty() && stack.peek() != null) {
                TreeNode node = stack.pop();
                if(leftToRight){
                    tmpStack.push(node.left);
                    tmpStack.push(node.right);

                } else{
                    tmpStack.push(node.right);
                    tmpStack.push(node.left);
                }
                System.out.println(node.val);
            }
            leftToRight = !leftToRight;
            stack = tmpStack;
            tmpStack = new Stack<>();
        }
    }


}
