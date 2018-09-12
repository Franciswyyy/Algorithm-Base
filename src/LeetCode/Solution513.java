package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {

        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode bottomLeft = root;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.right != null){
                queue.add(cur.right);
                bottomLeft = cur.right;
            }
            if(cur.left != null){
                queue.add(cur.left);
                bottomLeft = cur.left;
            }
        }
        return bottomLeft.val;
    }
}
