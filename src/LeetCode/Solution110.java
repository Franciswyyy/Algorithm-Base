package LeetCode;

public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int l = depth(root.left);
        int r = depth(root.right);

        if(Math.abs(l-r) <=1){
           return isBalanced(root.left) && isBalanced(root.right);
        }else return false;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int dep = 0;
        return Math.max(depth(root.right) + 1, depth(root.left) + 1);
    }
}
