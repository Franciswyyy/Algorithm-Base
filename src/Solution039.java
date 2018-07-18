import java.util.*;

public class Solution039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, int[] candidates, int target, List<Integer> cur, List<List<Integer>>res){

        if(start >= candidates.length || target < 0){return ;}
        if(target == 0){
            res.add(new ArrayList<>(cur));     // 注意了，不是直接添加cur，那样会是引用
            return;
        }

        for(int i = start; i < candidates.length ; i ++){
             cur.add(candidates[i]);

            if(candidates[i] <= target){
                // 这个i保证了，不会出现多种的结果, 不是i+1,是因为可以当前重复
                helper(i, candidates, target- candidates[i], cur, res);
            }

             cur.remove(cur.size()-1);
        }
        return ;

    }
}
