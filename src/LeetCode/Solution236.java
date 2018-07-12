package LeetCode;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        return (leftTree != null && rightTree != null) ? root : (leftTree == null) ? rightTree : leftTree;
    }
}
