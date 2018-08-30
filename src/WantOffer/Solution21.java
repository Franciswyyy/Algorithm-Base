package WantOffer;

import java.util.ArrayList;

public class Solution21 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(root, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(TreeNode root, int target, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
        if(root == null) return;
        sol.add(root.val);
        if(root.left == null && root.right == null && root.val == target){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if(root.left != null){
            helper(root.left, target-root.val, sol, res);
            sol.remove(sol.size()-1);
        }
        if(root.right != null){
            helper(root.right, target-root.val, sol, res);
            sol.remove(sol.size()-1);
        }
    }
}
