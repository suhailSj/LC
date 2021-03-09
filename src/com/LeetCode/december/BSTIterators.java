package com.LeetCode.december;

import com.LeetCode.util.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by suhail.jahangir on 10/12/20
 */
public class BSTIterators {

    static class BSTIterator {

        Queue<TreeNode> list = new LinkedList<>();
        public BSTIterator(TreeNode root) {
            createList(root);
        }

        private void createList(TreeNode root){
            if(root == null){
                return;
            }
            createList(root.left);
            list.add(root);
            createList(root.right);
        }

        public int next() {
            return list.remove().val;
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
