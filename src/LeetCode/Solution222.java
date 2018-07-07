package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution222 {

    // 超时
    public int countNodes11(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                count ++;
            }
            if(node.right != null){
                queue.add(node.right);
                count ++;
            }
        }
        return count;
    }
}
