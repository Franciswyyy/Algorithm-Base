package WantOffer;

public class Solution23 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int left = deep(root.left);
        int right = deep(root.right);
        if(Math.abs(left-right) <= 1) return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        else return false;

    }
    private int deep(TreeNode root){
        if(root == null) return 0;
        return Math.max(1 + deep(root.left), 1 + deep(root.right));
    }
}
