package com.LeetCode;

import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

public class BinaryTreeZigZag {



    static class Solution {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> tmpStack = new Stack<>();
            stack.push(root);
            int count =0;
            while(stack.isEmpty()) {
                ArrayList<Integer> li = new ArrayList<>();
                while(stack.isEmpty()){
                    TreeNode node = stack.pop();
                    li.add(node.val);
                    if(count%2 == 0){
                        tmpStack.add(node.left);
                        tmpStack.add(node.right);
                    } else{
                        tmpStack.add(node.right);
                        tmpStack.add(node.left);
                    }
                }
                result.add(li);
                count++;
                stack = tmpStack;
                tmpStack.clear();
            }
            return result;
        }
    }
}
