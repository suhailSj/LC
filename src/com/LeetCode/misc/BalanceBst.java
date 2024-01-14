package com.LeetCode.misc;

import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

/**
 * created by suhail.jahangir on 20/08/20
 */
public class BalanceBst {


    static class Solution {
        ArrayList<TreeNode> list = new ArrayList<>();
        public TreeNode balanceBST(TreeNode root) {
            traverseTree(root);
            return createTree(0, list.size()-1);
        }

        private TreeNode createTree(int start, int end) {
            int mid = start+ (end-start)/2;
            TreeNode node = list.get(mid);
            node.left = createTree(start, mid-1);
            node.right = createTree(mid+1, end);
            return node;
        }

        public void traverseTree(TreeNode root){
            if(root == null){
                return;
            }
            traverseTree(root.left);
            list.add(root);
            traverseTree(root.right);
        }


    }





}
