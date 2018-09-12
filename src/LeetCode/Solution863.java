package LeetCode;

import java.util.*;

public class Solution863 {

    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null || K < 0) return res;
        helper(root, null);
        if(!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(K == 0){
                for(int i = 0; i < size; i ++) res.add(queue.poll().val);
                return res;
            }
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                for(TreeNode cur : map.get(node)){
                    if(visited.contains(cur)) continue;
                    visited.add(cur);
                    queue.add(cur);
                }
            }
            K--;
        }
        return res;
    }

    // 构建map，结点->与结点相邻的结点
    private void helper(TreeNode node, TreeNode parent){
        if(node == null) return;
        if(!map.containsKey(node)){
            map.put(node, new ArrayList<>());
            if(parent != null) {     // 第一次根节点为null，并不会执行这一步
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            helper(node.left, node);
            helper(node.right, node);
        }
    }

}
