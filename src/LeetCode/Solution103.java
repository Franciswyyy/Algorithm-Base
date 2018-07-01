package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;

        List<Integer> subList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i ++){
                TreeNode node = queue.poll();
                if(flag){
                    subList.add(node.val);
                }else {
                    subList.add(0, node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(subList);
            flag = flag ? false : true;
        }
        return res;
    }
}
