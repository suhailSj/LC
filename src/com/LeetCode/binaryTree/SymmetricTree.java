package com.LeetCode.binaryTree;

/**
 * created by suhail.jahangir on 06/09/20
 */

import com.LeetCode.util.Tree.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
           return process(root.left, root.right);
        }

        public boolean process(TreeNode left, TreeNode right){

            if(left == null && right == null){
                return true;
            }
            if(right == null || left == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            return process(left.left, right.right) && process(left.right, right.left);
        }

    }

}
