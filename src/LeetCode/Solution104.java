package LeetCode;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int rDepth = maxDepth(root.right);
        int lDepth = maxDepth(root.left);
        return Math.max(rDepth+1, lDepth+1);
    }
}
