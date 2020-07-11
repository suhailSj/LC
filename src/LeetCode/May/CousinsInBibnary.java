package LeetCode.May;

public class CousinsInBibnary {



    class Solution {
        public class TreeNode {
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
        public boolean isCousins(TreeNode root, int x, int y) {
            return checkForCousins(root, x,y,0);
        }
        int xlevel=-1; int ylevel = -1;
        public boolean checkForCousins(TreeNode root, int x, int y, int level) {
            if(root == null) {
                return false;
            }
            boolean xCh= false;
            boolean yCh =false;

            if(root.left != null){
                if(root.left.val ==x ){
                    xlevel = level;
                    xCh = true;
                }
                if(root.left.val ==y){
                    ylevel = level;
                    yCh = true;
                }
            }
            if(root.right != null){
                if(root.right.val ==x){
                    xlevel = level;
                    xCh = true;
                }
                if(root.right.val ==y){
                    ylevel = level;
                    yCh = true;
                }
            }
            if(xCh && yCh){
                return false;
            }else if(ylevel == xlevel && xlevel >0 && !(xCh && yCh) ){
                return true;
            } else {
                return checkForCousins(root.left, x, y, level+1) ||checkForCousins(root.right, x, y, level+1);
            }
        }
    }
}
