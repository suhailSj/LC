package LeetCode.binaryTree;

/**
 * created by suhail.jahangir on 06/09/20
 */

import LeetCode.Tree.TreeNode;

import java.util.Arrays;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    The trick is , post order last element is root,
 *    find it in inorder, now from inorder count elements to right these many elements before root in post oder will be used as right sub part
 */
public class TreeFromInorderAndPostOrder {

    public static void main(String... a){
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.print(node);
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length == 0){
                return  null;
            }

            TreeNode root = new TreeNode(postorder[postorder.length-1]);
            int index = -3;

            for(int i =0;i< inorder.length;i++){
                if(inorder[i]==root.val){
                    index = i;
                    break;
                }
            }
            if(index >=0){
                int i = inorder.length - index-1;
                root.left = buildTree(Arrays.copyOfRange(inorder, 0,index), Arrays.copyOfRange(postorder, 0,postorder.length-i-1));
                root.right = buildTree(Arrays.copyOfRange(inorder, index+1, inorder.length), Arrays.copyOfRange(postorder, postorder.length-i-1,postorder.length-1));
            }
            return root;
        }
    }
}
