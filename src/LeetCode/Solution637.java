package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double tmp = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode cur = queue.poll();
                if(cur.right != null) queue.add(cur.right);
                if(cur.left != null) queue.add(cur.left);
                tmp += cur.val;
            }
            res.add(tmp/size);
            tmp = 0;
        }
        return res;
    }
}
