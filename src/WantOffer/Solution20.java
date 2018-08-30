package WantOffer;

public class Solution20 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       if(root1 != null &&  root2 != null){
            return helper(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
       }
       return false;
    }

    private boolean helper(TreeNode roo1, TreeNode root2){
        if(root2 == null) return true;
        if(roo1 == null) return false;
        if(roo1.val != root2.val) return false;
        return helper(roo1.left, root2.left) && helper(roo1.right, root2.right);
    }

}
