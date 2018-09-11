package LeetCode;

public class Solution669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;

        if(root.val < L) return trimBST(root.right, L, R);
        // 由于是二叉查找树, 当根节点都小于L, 那么左边的都不行了, 同理
        if(root.val > R) return trimBST(root.left, L, R);
        TreeNode node = new TreeNode(root.val);
        node.left = trimBST(root.left, L, R);
        node.right = trimBST(root.right, L, R);
        return node;
    }

}
