package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution046 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);   // 不是必要的
        helper(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, int[] nums, List<Integer>cur, List<List<Integer>>res){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        // 前面的值也要
        for(int i = 0; i < nums.length; i ++){
            if(cur.contains(nums[i])) continue;

            cur.add(nums[i]);
            helper(i + 1, nums, cur, res);
            cur.remove(cur.size()-1);
        }
    }

}
