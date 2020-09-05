package LeetCode.september;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by suhail.jahangir on 05/09/20
 */

/**
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 */
public class MergeTwoBST {

    static class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            inOrder(root1, list1);
            inOrder(root2, list2);
            return merge(list1, list2);
        }

        private List<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            ArrayList<Integer> ans = new ArrayList<>(list1.size()+list2.size());
            int i=0; int j=0;
            while (i<list1.size() && j<list2.size()){
                if(list1.get(i) < list2.get(j)){
                    ans.add(list1.get(i));
                    i++;
                } else{
                    ans.add(list2.get(j));
                    j++;
                }
            }
            while(i<list1.size()){
                ans.add(list1.get(i++));

            }
            while(j<list1.size()){
                ans.add(list1.get(j++));
            }
            return ans;
        }

        public void inOrder(TreeNode root, ArrayList<Integer> list){
           if(root == null){
               return;
           }
           inOrder(root.left, list);
           list.add(root.val);
           inOrder(root.right, list);
        }


    }
}
