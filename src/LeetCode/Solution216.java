package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    public void helper(int k, int target, int start, List<Integer>cur, List<List<Integer>>res){

        if( k==0 && target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i <= 9; i ++){
            if(target < i) continue;
            cur.add(i);
            helper(k-1, target-i, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
