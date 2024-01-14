package com.LeetCode.year2020.medium;

import com.LeetCode.util.Tree.TreeNode;

/**
 * created by suhail.jahangir on 19/09/20
 */
public class IsValidBSTWithoutExtraStorage {

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return process(root,Long.MAX_VALUE, Long.MIN_VALUE);
        }
        public boolean process(TreeNode root, long max, long min){
            if(root == null){
                return true;
            }
            if(root.val <=min || root.val >= max){
                return false;
            }
            return process(root.left, root.val,min) && process(root.right, max, root.val);
        }
    }
}
