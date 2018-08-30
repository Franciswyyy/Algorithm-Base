package WantOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution26 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;   //true代表从左到右
        ArrayList<Integer> sol = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                sol.add(cur.val);
            }

            if(flag){
                res.add(new ArrayList<>(sol));
                sol.clear();
                flag = false;

            }else{
                ArrayList<Integer> tmp = helper(sol);
                res.add(new ArrayList<>(tmp));
                sol.clear();
                tmp.clear();
                flag = true;
            }
        }
        return res;
    }
    private static ArrayList helper(ArrayList<Integer> list){
        int size = list.size();
        ArrayList<Integer> reverse = new ArrayList<>();
        for(int i = list.size()-1; i >= 0; i --){
            reverse.add(list.get(i));
        }
        return reverse;
    }
}
