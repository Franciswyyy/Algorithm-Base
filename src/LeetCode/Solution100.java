package LeetCode;

public class Solution100 {


    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;

        if(p.val == q.val){
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }
        return false;
    }



    // 写的bullshit
    public boolean isSameTree111(TreeNode p, TreeNode q) {

        if(p != null && q != null){
            if(p.val != q.val){
               return isSameTree111(p.left, q.left) && isSameTree111(p.right, q.right);
            }
        }else if(p == null && q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }else{
            return true;
        }
        return true;
    }
}
