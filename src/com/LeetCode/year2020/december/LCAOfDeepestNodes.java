package com.LeetCode.year2020.december;

import com.LeetCode.util.Tree.TreeHelper;
import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

/**
 * created by suhail.jahangir on 13/12/20
 */
public class LCAOfDeepestNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lcaDeepestLeaves(TreeHelper.initialize(new Integer[]{1,4,2,5,null,6,3,null,8,null,null,7})));
    }
    static class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            //HashMap<Integer, LinkedList<TreeNode>> map = new HashMap<>();
            ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
            process(root, 0, arrayList);
            int lastRow = arrayList.size()-1;
            if (lastRow == 0){
                return root;
            }
            LinkedList<TreeNode> tempList = arrayList.get(lastRow);
            boolean fi = true;
            HashSet<TreeNode> internal = new HashSet<>();
            while(tempList.size()>1 || fi){
                fi = false;

                lastRow--;
                for(TreeNode node : arrayList.get(lastRow)){
                    if(node.left == tempList.peekFirst() && node.left != null){
                        tempList.removeFirst();
                        internal.add(node);
                    }
                    if(node.right == tempList.peekFirst() && node.right != null){
                        tempList.removeFirst();
                        internal.add(node);
                    }
                }
                tempList.clear();

                tempList = new LinkedList<>(internal);
                internal.clear();
            }

            return tempList.get(0);
        }

        private void process(TreeNode root, int i, ArrayList<LinkedList<TreeNode>> map) {
            if(root == null){
                return;
            }
            if(map.size() <= i){
                map.add(new LinkedList<TreeNode>());
            }
            LinkedList<TreeNode> list = map.get(i) ;
            list.add(root);

            process(root.left, i+1, map);
            process(root.right, i+1, map);
        }
    }
}
