package LeetCode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution337 {


    // 以为只能取一层一层的节点数
    public int rob(TreeNode root) {

        if(root == null) return 0;

        int preNo = 0;
        int preYes = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int num = 0;
        while(!queue.isEmpty()){
            int levelCount = queue.size();

            for(int i = 0; i < levelCount; i ++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                num += queue.poll().val;

                if(i == levelCount-1){
                    int temp = preNo;
                    preNo = Math.max(preNo, preYes);
                    preYes = temp + num;
                    num = 0;
                    break;
                }
            }
        }
        return Math.max(preNo, preYes);
    }

    public int rob1(TreeNode root){
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }

    // 0 不访问， 1 访问
    private int[] dfs(TreeNode x){
        if(x == null) return new int[2];

        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = x.val + left[0] + right[0];
        return res;
    }
}
