package WantOffer;

import java.util.Stack;

public class Solution31 {

    public TreeNode Convert(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null; // 中序遍历的上一个结点
        boolean isFirst = true;
        while(p!= null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;    //中序遍历的第一个节点记为root
                pre = root;
                isFirst = false;
            }else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }
}
