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
            TreeNode node = null;
            Queue<TreeNode> tmpQueue = null;
            while (!queue.isEmpty()){
                tmpQueue = new LinkedList<>();
                List<Integer> li = new ArrayList<>();
                while (!queue.isEmpty()){
                    node = queue.remove();
                    li.add(node.val);
                    if(node.left != null)tmpQueue.add(node.left);
                    if(node.right != null)tmpQueue.add(node.right);
                }
                queue = tmpQueue;
                ans.add(li);
            }
            return ans;
        }
    }
}
