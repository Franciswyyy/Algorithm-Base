package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution047 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, boolean[] used, List<Integer>cur, List<List<Integer>>res){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }

        for(int i = 0; i < nums.length; i ++){
            if(used[i]) continue;
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            cur.add(nums[i]);
            helper(nums, used, cur, res);
            used[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
