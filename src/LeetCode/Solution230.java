package LeetCode;

import java.util.Stack;

public class Solution230 {

    // 不用递归，只用中序遍历
    public int kthSmallest01(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int res = 0;

        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(++res == k){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }


    public int kthSmallest(TreeNode root, int k){
        int count = countNodes(root.left);
        if(k <= count){   // 当做左子树已经有k个了, 那么肯定在root的左子树中
            return kthSmallest(root.left,k);
        }else if(k > count + 1){            // 1是当前的root节点
            return kthSmallest(root.right, k-1-count);
        }
        return root.val;
    }

    private int countNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
