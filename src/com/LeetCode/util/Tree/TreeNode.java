package com.LeetCode.util.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by suhail.jahangir on 28/09/20
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return "["+this.val+","+this.left+","+this.right+"]";
    }
}
