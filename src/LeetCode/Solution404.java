package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int res = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null)
                res += root.left.val;
            else res += sumOfLeftLeaves(root.left);
        }

        res += sumOfLeftLeaves(root.right);

        return res;
    }

    // 非递归
    public int sumOfLeftLeaves1(TreeNode root){

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null){
                if(node.left.left == null && node.left.right == null){
                    res += node.left.val;
                }
                queue.add(node.left);
            }
            if(node.right != null)
                queue.add(node.right);
        }
        return res;

}


}
