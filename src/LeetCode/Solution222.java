package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution222 {


    // 如果不超时，则就计算其深度，通过完全二叉树的性质来计算总共的节点
    public int countNodes1(TreeNode root){
        int ld = leftDepth(root.left);
        int rd = rightDepth(root.right);

        if(ld == rd) return (1 << ld) -1;
        else return 1 + countNodes1(root.right) + countNodes1(root.left);
    }

    private int leftDepth(TreeNode root){
        int dep = 0;
        while(root != null){
            dep ++;
            root = root.left;
        }
        return dep;
    }

    private int rightDepth(TreeNode root){
        int dep = 0;
        while(root != null){
            dep ++;
            root = root.right;
        }
        return dep;
    }


    // 超时，过不了，因为对栈的内存有要去，而且时间复杂度为与深度有关。
    public int countNodes(TreeNode root){
        if(root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }



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
