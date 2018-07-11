package LeetCode;

public class Solution111 {


    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }


    // 求深度是当两侧有一处为空时，则以长的那一边来计算
    public int minDepth1(TreeNode root){
        if(root == null) return 0;

        if(root.left != null && root.right != null){
            return Math.min(minDepth1(root.right), minDepth1(root.left)) + 1;
        }else {
            return Math.max(minDepth1(root.left), minDepth1(root.right)) + 1;
        }
    }
}
