package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution077 {

    public List<List<Integer>> combine(int n, int k) {


        List<List<Integer>> res = new ArrayList<>();
        if(n < k || k <= 0) return res;
        helper(k, n,1, new ArrayList<>(), res);
        return res;
    }

    public void helper(int k, int n, int start, List<Integer>cur, List<List<Integer>>res){


        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }


//        for(int i = start; i <= n; i ++){
        for(int i = start; i <= n-(k-cur.size())+1; i++){
            cur.add(i);
            helper(k, n,i+1,  cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
