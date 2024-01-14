package com.LeetCode.year2020.medium;

/**
 * created by suhail.jahangir on 22/02/21
 */

import com.LeetCode.util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
public class DeleteNodeReturnForest {
    static class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i: to_delete){
                set.add(i);
            }
            if(process(root, set) != null){
                ans.add(root);
            }
            return ans;
        }
        List<TreeNode> ans = new ArrayList<>();

        public TreeNode process(TreeNode root, HashSet<Integer> set){
            if(root == null){
                return null;
            }
            if(set.contains(root.val)){
                if(root.left != null && !set.contains(root.left.val)){
                    ans.add(root.left);
                }
                if(root.right != null && !set.contains(root.right.val)){
                    ans.add(root.right);
                }
                process(root.left, set);
                process(root.right, set);
                return null;
            } else{
                root.left = process(root.left, set);
                root.right = process(root.right, set);
                return root;
            }
        }
    }
}
