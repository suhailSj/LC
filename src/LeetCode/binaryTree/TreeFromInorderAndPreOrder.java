package LeetCode.binaryTree;

/**
 * created by suhail.jahangir on 07/09/20
 */

import LeetCode.Tree.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class TreeFromInorderAndPreOrder {

    public static void main(String... a){
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.print(node);
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return process(preorder, inorder, 0,preorder.length, 0,inorder.length);
        }

        int pre =0;
        public TreeNode process(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
            if(inEnd <= inStart){
                return null;
            }
            TreeNode root = new TreeNode(preorder[pre++]);

            int index = -1;
            for(int i=inStart;i<inEnd;i++){
                if(inorder[i] == root.val){
                    index = i;
                    break;
                }
            }

            root.left = process(preorder, inorder, preStart+1, preEnd, inStart,index);
            root.right = process(preorder, inorder, preStart+1, preEnd, index+1,inEnd);
            return root;
        }
    }
}
