package LeetCode;

// 递归中又嵌套了一个递归
public class Solution437 {

    // 以root为根节点的二叉树，寻找和为sum的路径
    public int pathSum(TreeNode root, int sum) {

        if(root == null)
            return 0;

        // 没有要求终止的节点为叶子节点，就可以一直搜索为空的位置

        int res = findPath(root, sum);   // 包含这个节点
        res += pathSum(root.left, sum);  // 不包含这个节点的数
        res += pathSum(root.right, sum);

        return res;
    }

    // 以node为根节点，包含node的路径
    private int findPath(TreeNode node, int num){

        if(node == null)
            return 0;

        int res = 0;
        if(node.val == num){
            res += 1;
            // 此时不要立即返回，因为出现负数，可能减一下，再加一下就又是一条路径了
        }

        res += findPath( node.left, num - node.val);
        res += findPath( node.right, num - node.val);

        return res;
    }



}
