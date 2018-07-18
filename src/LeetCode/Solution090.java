package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, int[] nums, List<Integer>cur, List<List<Integer>> res){

        res.add(new ArrayList<>(cur));

        for(int i = start; i < nums.length; i ++){
            if(i > start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            helper(i+1, nums,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}
