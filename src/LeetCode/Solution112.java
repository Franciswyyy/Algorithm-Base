package LeetCode;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) return false;    //根节点

        if(root.right == null && root.left == null)   // 叶子节点
            return root.val == sum;


        if(hasPathSum(root.left, sum - root.val))
            return true;

        if(hasPathSum(root.right, sum - root.val))
            return true;

        return false;


        /*
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
        */
    }
}
