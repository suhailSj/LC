package com.LeetCode.monthChallenge;

import com.LeetCode.util.Tree.TreeHelper;
import com.LeetCode.util.Tree.TreeNode;

public class MaxWitdthOfTree {
    public static void main(String... a){
        TreeNode root = TreeHelper.initialize(new Integer[]{1,2,3});
        Solution sol = new Solution();
        System.out.println(sol.maxPathSum(root));
    }

    static class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            process(root);
            return max;
        }

        public int process(TreeNode root){
            if(root == null) {
                return 0;
            }
            int left = process(root.left);
            int right = process(root.right);
            int m = Math.max(left, right);
            max = Math.max(max, root.val+left+right);
            return root.val+m;
        }
    }


}
