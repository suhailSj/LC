package com.LeetCode.util.Tree;

/**
 * created by suhail.jahangir on 28/09/20
 */
import java.util.LinkedList;
import java.util.Queue;

public class TreeHelper {

    public static TreeNode initialize(Integer[] arr) {
        if(arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        TreeNode head = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int len = arr.length;
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
                if (i < len) {
                    Integer tmp = arr[i++];
                    if(tmp == null){
                        node.left = null;
                    }else{
                        node.left = new TreeNode(tmp);
                        queue.add(node.left);
                    }
                }
                if (i < len) {
                    Integer tmp = arr[i++];
                    if(tmp == null){
                        node.right = null;
                    }else{
                        node.right = new TreeNode(tmp);
                        queue.add(node.right);
                    }
                }
        }
        return root;

    }

    public static void printTree(TreeNode root){
        if(root == null){
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> tmp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()){

            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                sb.append(node.val);
                sb.append(",");
                if(node.left!=null){
                    tmp.add(node.left);
                }
                if(node.right != null){
                    tmp.add(node.right);
                }
            }
            queue.addAll(tmp);
            tmp.clear();
        }
        System.out.println(sb.substring(0,sb.length()-1)+"]");
    }
}

