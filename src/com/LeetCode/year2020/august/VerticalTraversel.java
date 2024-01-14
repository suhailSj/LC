package com.LeetCode.year2020.august;

import com.LeetCode.util.Tree.TreeHelper;
import com.LeetCode.util.Tree.TreeNode;

import java.util.*;

/**
 * created by suhail.jahangir on 09/08/20
 */
public class VerticalTraversel {

    public static void main(String... a){
        Solution sol  =new Solution();
        TreeNode root = TreeHelper.initialize(new Integer[]{0,1,18,2,32,null,21,3,5,null,null,null,49,7,4,8,6,null,null,19,29,11,26,10,14,9,13,null,24,null,37,null,null,28,null,31,20,17,15,12,27,30,null,null,null,38,40,null,41,null,42,22,34,null,null,16,35,null,null,null,39,33,55,51,45,47,null,null,null,56,null,25,null,50,43,36,23,null,null,null,44,null,53,null,null,null,58,48,46,52,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,54,null,null,59,null,57});
        System.out.println(sol.verticalTraversal(root));
    }
    static class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeObj> queue = new LinkedList<>();
            LinkedList<TreeObj> tmp = new LinkedList<>();
            queue.add(new TreeObj(0, root));
            while (!queue.isEmpty()) {
                tmp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    TreeObj obj = queue.remove();
                    if (obj == null || obj.node == null) {
                        continue;
                    }
                    if (obj.level < min) {
                        min = obj.level;
                    }
                    if (obj.level > max) {
                        max = obj.level;
                    }
                    List<Integer> list = map.getOrDefault(obj.level, new ArrayList<Integer>());
                    list.add(obj.node.val);
                    map.put(obj.level, list);
                    if(obj.node.left != null)tmp.add(new TreeObj(obj.level - 1, obj.node.left));
                    if(obj.node.right != null)tmp.add(new TreeObj(obj.level + 1, obj.node.right));
                }
                Collections.sort(tmp, (a,b) ->{
                    if(a.level == b.level ){
                        return a.node.val - b.node.val;
                    }
                    return Integer.compare(a.level, b.level);
                });
                queue = tmp;

            }
            for (int i = min; i <= max; i++) {
                ans.add(map.get(i));
            }
            return ans;
        }

        int min = 0;
        int max = 0;

        class TreeObj {
            public int level;
            public TreeNode node;

            public TreeObj(int level, TreeNode node) {
                this.level = level;
                this.node = node;
            }
        }
    }
}
