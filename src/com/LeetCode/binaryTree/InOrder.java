package com.LeetCode.binaryTree;

/**
 * created by suhail.jahangir on 06/09/20
 */

import com.LeetCode.util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class InOrder {

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = null;
            stack.add(root);
            root = root.left;
            while(!stack.isEmpty() || root != null){
                while(root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;

            }

            return ans;
        }


    }
}
