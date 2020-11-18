package com.LeetCode.binaryTree;

/**
 * created by suhail.jahangir on 05/09/20
 */

import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PreOrder {

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            Queue<TreeNode> tmpQueue =  null;
            stack.add(root);
            TreeNode node = null;
            while(!stack.isEmpty()) {
                    node = stack.pop();
                    ans.add(node.val);
                    if(node.right != null)
                        stack.add(node.right);
                    if(node.left != null)
                        stack.add(node.left);


            }
            return ans;
        }
    }
}
