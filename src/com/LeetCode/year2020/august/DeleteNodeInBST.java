package com.LeetCode.year2020.august;

import com.LeetCode.util.Tree.TreeNode;

/**
 * created by suhail.jahangir on 01/09/20
 */
public class DeleteNodeInBST {

    public static void main(String... a){

    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){
                return null;
            }
            if(root.val == key){
                root = selectReplacement(root);
                return root;
            }
            if(root.val > key){
                deleteNode(root.left, key);
            } else{
                deleteNode(root.right, key);
            }
            return root;
        }

        public TreeNode selectReplacement(TreeNode root){
            if(root == null){
                return null;
            }

            if(root.left == null){
                if(root.right!= null){
                    root.val = root.right.val;
                    root.left = root.right.left;
                    root.right = root.right.right;
                }
                return root;
            }
            if(root.right == null){
                if(root.left!= null){
                    root.val = root.left.val;
                    root.right = root.left.right;
                    root.left = root.left.left;
                }
                return root;
            }
            TreeNode tmp = root.left;
            root.val = root.left.val;
            root.left = selectReplacement(root.left);
            return root;
        }
    }
}
