package LeetCode;

public class Solution450 {

    /**
     * 删除节点，首先找到要删除的这个节点：
     * 1、节点没有左右子树，返回null
     * 2、节点只有左子树，返回左子树
     * 3、节点只有右子树，返回右子树
     * 4、节点都有左右子树，找右子树的最小节点，把值赋给其要删的节点，
     *     在重复递归删除其右子树的这个节点，肯定是叶子节点、直接为null
     * @param root
     * @param key
     * @return
     */

    public TreeNode deleteNode(TreeNode root, int key){

        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.right == null)
                return root.left;
            else if(root.left == null)
                return root.right;

            // 找要删的右子树的最小节点
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    // 找当前节点这棵树最小的节点
    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
