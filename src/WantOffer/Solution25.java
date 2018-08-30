package WantOffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印每一层
 */
public class Solution25 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;

        ArrayList<Integer> sol = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                sol.add(cur.val);
            }
            res.add(new ArrayList<>(sol));
            sol.clear();
        }
        return res;
    }
}
