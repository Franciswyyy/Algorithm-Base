package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    //  有进步，知道这种类型的递归， 需要写两个方法
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer>sol, List<List<Integer>>res){
        if(root == null)
            return;

        sol.add(root.val);

        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if(root.left != null){
            helper(root.left, sum-root.val, sol, res);
            sol.remove(sol.size()-1);
        }
        if(root.right != null){
            helper(root.right, sum-root.val, sol, res);
            sol.remove(sol.size()-1);
        }

        // 或者写在一起也是可以的~
    }
}
