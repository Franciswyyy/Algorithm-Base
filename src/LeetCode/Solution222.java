package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution222 {


    public int countNodes2(TreeNode root){
        if(root == null) return 0;
        int lh = height1(root.left);
        int rh = height1(root.right);
        if(lh == rh){
            return (1 << lh) + countNodes2(root.right);    // 根节点  1 + 1<<lh -1
        }else{
            return (1 << rh) + countNodes2(root.left);
        }
    }
    private int height1(TreeNode root){
        if(root == null) return 0;
        return 1 + height1(root.left);
    }


    public int countNodes1(TreeNode root){
       int h = height(root);
       int num = 0;
       while(root != null){
           if(h-1 == height(root.right)){
               num += 1 << h;
               root = root.right;
           }else {
               num += 1 << h-1;
               root = root.left;
           }
           h--;
       }
       return num;
    }
    private int height(TreeNode root){
        return root == null ? 0 : height(root.left) + 1;
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
