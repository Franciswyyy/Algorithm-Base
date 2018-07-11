package LeetCode;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution098 {

    // 中序遍历就能得一个有序数组
    public boolean isValidBST(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

//        if(!stack.isEmpty()),已经判断过的，不需要添加
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        if(res.size() == 0 || res.size() == 1) return true;
        for(int i = 1; i < res.size(); i ++){
            if(res.get(i) < res.get(i-1))
                return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root){

        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // pre已经是最左边的点，root取的要不是其上一步的点，要不就是pre的右子树的点
            // 总之，都是pre都是比其小的点
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root){
        return isValidBBSSTT(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBBSSTT(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;

        if(root.val >= maxVal || root.val < minVal) return false;

        return isValidBBSSTT(root.left, minVal, root.val) && isValidBBSSTT(root.right, root.val, maxVal);
    }
}
