package com.LeetCode.binaryTree;

import com.LeetCode.util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by suhail.jahangir on 06/09/20
 */
public class PostOrder {

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            while(true){

                while(root!= null){
                    stack.add(root);

                    stack.add(root);
                    root = root.left;
                }
                if(stack.isEmpty()){
                    return ans;
                }
                root = stack.pop();
                if(!stack.isEmpty() && stack.peek() == root){
                    root = root.right;
                } else {
                    ans.add(root.val);
                    root = null;
                }

            }
        }
    }
}
