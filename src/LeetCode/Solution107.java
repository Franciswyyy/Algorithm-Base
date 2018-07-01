package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {

    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;

        Queue<TreeNode>  queue = new LinkedList<>();
        List<Integer> subList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            subList = new ArrayList<>();
            for(int i = 0; i < levelNum; i ++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            res.addFirst(subList);

        }
        return res;
    }


    // DFS
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelMarker(res, root, 0);
        return res;
    }
    public void levelMarker(List<List<Integer>> list, TreeNode root, int level){
        if(root == null) return;
        if(level >= list.size()){   //要创建子数组
            list.add(0, new ArrayList<>());
        }
        levelMarker(list, root.left, level + 1);
        levelMarker(list, root.right, level + 1);
        list.get(list.size()-level-1).add(root.val);
    }
}
