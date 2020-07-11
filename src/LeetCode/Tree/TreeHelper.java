package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeHelper {

    public static TreeNode initialize(Integer[] arr) {
        if(arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        TreeNode head = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int len = arr.length;
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node != null){
                if (i < len) {
                    Integer tmp = arr[i++];
                    if(tmp == null){
                        node.left = null;
                    }else{
                        node.left = new TreeNode(tmp);
                    }
                }
                if (i < len) {
                    Integer tmp = arr[i++];
                    if(tmp == null){
                        node.right = null;
                    }else{
                        node.right = new TreeNode(tmp);
                    }
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
         return root;

    }
}
