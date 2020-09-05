package LeetCode.binaryTree;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * created by suhail.jahangir on 06/09/20
 */
public class LevelOrderTraversal {

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
        }
    }
}
