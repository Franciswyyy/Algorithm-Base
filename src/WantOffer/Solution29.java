package WantOffer;

import java.util.ArrayList;
import java.util.Stack;

public class Solution29 {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while(!stack.isEmpty() || pRoot != null){

            while(pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }

            pRoot = stack.pop();
            index++;
            if(index == k) return pRoot;
            pRoot = pRoot.right;
        }
       return null;
    }

}
