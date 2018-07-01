package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> tmp;
        int size;
        while(!queue.isEmpty()){
            tmp = new LinkedList<Integer>();
            size = queue.size();
            for(int i = 0; i < size; i ++){
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                tmp.add(queue.poll().val);
            }
            res.add(tmp.get(0));
        }
        return res;
    }
}
