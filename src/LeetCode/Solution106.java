package LeetCode;

import java.util.HashMap;

public class Solution106 {
    HashMap<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i ++){
            indexForInOrders.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode helper(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inStart;

        TreeNode leftChild = helper(inOrder, inStart, inIndex-1, postOrder, postStart, postStart+leftTreeSize-1);
        TreeNode rightChild = helper(inOrder, inIndex+1, inEnd, postOrder, postStart+leftTreeSize, postEnd-1);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
