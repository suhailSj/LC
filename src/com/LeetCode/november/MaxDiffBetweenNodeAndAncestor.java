package com.LeetCode.november;

/**
 * created by suhail.jahangir on 09/11/20
 */

import com.LeetCode.util.Tree.TreeHelper;
import com.LeetCode.util.Tree.TreeNode;

/**
 * Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */
public class MaxDiffBetweenNodeAndAncestor {
    public static void main(String... a) {
        Solution s = new Solution();
        System.out.println(s.maxAncestorDiff(TreeHelper.initialize(new Integer[]{1,null,2,null,0,3})));
        System.out.println(s.maxAncestorDiff(TreeHelper.initialize(new Integer[]{8,3,10,1,6,null,14,null,null,4,7,13})));
    }

    static class Solution {
        int val = 0;
        public int maxAncestorDiff(TreeNode root) {
            if(root == null){
                return 0;
            }
            process(root);
            return val;
        }

        private Integer[] process(TreeNode node) {
            if(node == null){
                return null;
            }

            Integer[] left = process(node.left);
            Integer[] right = process(node.right);
            int max =0;
            int minNum = node.val;
            int maxNum = node.val;
            if(left!= null){
                max = Math.max(Math.abs(node.val - left[0]),max);
                max = Math.max(Math.abs(node.val - left[1]),max);
                minNum = Math.min((left[0]), minNum);
                maxNum = Math.max((left[1]), maxNum);
            }
            if(right != null){
                max = Math.max(Math.abs(node.val - right[0]),max);
                max = Math.max(Math.abs(node.val - right[1]),max);
                minNum = Math.min((right[0]), minNum);
                maxNum = Math.max((right[1]), maxNum);
            }
            val = Math.max(val, max);
            return new Integer[]{minNum, maxNum};
        }

    }
}
