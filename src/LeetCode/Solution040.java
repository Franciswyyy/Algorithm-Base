package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, int[] nums, int target, List<Integer>cur, List<List<Integer>>res){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }


        for(int i = start; i < nums.length; i ++){
            if(i > start && nums[i] == nums[i-1])continue;
            cur.add(nums[i]);
            helper(i+1, nums, target-nums[i], cur, res);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
