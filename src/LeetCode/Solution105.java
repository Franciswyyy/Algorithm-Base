package LeetCode;

import java.util.HashMap;

public class Solution105 {
    HashMap<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i ++){
            indexForInOrders.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    private TreeNode helper(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inStart;

        TreeNode leftChild = helper(inOrder, inStart, inIndex-1, preOrder, preStart+1, preStart+leftTreeSize);
        TreeNode rightChild = helper(inOrder, inIndex+1, inEnd, preOrder, preStart+leftTreeSize+1, preEnd);
        root.right = rightChild;
        root.left = leftChild;
        return root;
    }
}
