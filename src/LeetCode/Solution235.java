package LeetCode;

public class Solution235 {

    // 题目要求 p，q 不相等且都存在
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;  // 不管root等于p或q,都是该点
    }
}
