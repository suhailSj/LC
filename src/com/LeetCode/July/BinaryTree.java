package com.LeetCode.July;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {



      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String... a) {
        Solution sol = new Solution();
        System.out.println(sol.levelOrderBottom(new TreeNode(8)));
    }

    static class Solution {
          int value =0;
        List<List<Integer>> list = new LinkedList<>();
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            process(root, 0);
            Collections.reverse(list);
            return list;
        }

        public void process(TreeNode root, int level) {
            if(root == null){
                return;
            }
            process(root.left, level+1);
            process(root.right, level+1);
            List<Integer> innerList = null;
            if(list.size() <= level){
                innerList = new LinkedList<>();
            } else{
                innerList = list.get(level);
            }

            innerList.add(root.val);
            list.remove(level);
            list.add(level, innerList);

        }
    }
}
