package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {

    public boolean isSymmetric(TreeNode root) {

        return root ==null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null) return left==right;    // 两个为空true，有一个为空则为false

        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
    }



    // 非递归， 用队列来写
    public boolean isSymmetric1(TreeNode root) {

        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);


        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
