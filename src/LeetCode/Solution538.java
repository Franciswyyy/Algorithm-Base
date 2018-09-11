package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode node){
       if(node == null) return;
       helper(node.right);
       node.val += sum;
       sum = node.val;
       helper(node.left);
    }

}
