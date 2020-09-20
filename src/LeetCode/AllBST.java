package LeetCode;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllBST {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.generateTrees(3));
    }

    static class Solution {

        public List<TreeNode> generateTrees(int n) {
//            int[] arr = new int[n];
//
//            for(int i=0; i<n;i++){
//                arr[i] = i+1;
//            }
            List<TreeNode> list = new ArrayList<TreeNode>();
            for(int i=1;i<=n;i++){
                list.addAll(process(i,i-1,i+1,n+1,0, i));
            }

            return list;
        }

        public List<TreeNode> process(int num, int left, int right, int max, int min, int orig){
            List<TreeNode> leftPart = new ArrayList<TreeNode>();;
            List<TreeNode> rightPart = new ArrayList<TreeNode>();;
            if(left > min)
                leftPart = process(left, left-1,left+1, orig,min, orig);
            else{
                leftPart.add(null);
            }
            if(right < max)
                rightPart = process(right, right-1,right+1, max,orig, orig);
            else
                rightPart.add(null);


            TreeNode root = new TreeNode(num);
            List<TreeNode> list = new ArrayList<TreeNode>();
            for(TreeNode leftCh : leftPart){
                for(TreeNode rightCh : rightPart){
                    root.left = leftCh;
                    root.right = rightCh;
                    list.add(root);
                    root = new TreeNode(num);
                }
            }
            if(list.isEmpty()){
                list.add(root);
            }
            return list;
        }
    }
}
