package LeetCode.monthChallenge;

import LeetCode.Tree.TreeHelper;
import LeetCode.Tree.TreeNode;

public class MaxWitdthOfTree {
    public static void main(String... a){
        TreeNode root = TreeHelper.initialize(new Integer[]{1,2,3});
        Solution sol = new Solution();
        System.out.println(sol.maxPathSum(root));
    }

    static class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            int m = Math.max(left, right);
            max = Math.max(max, root.val+left+right);
            return root.val+m;
        }
    }
}
