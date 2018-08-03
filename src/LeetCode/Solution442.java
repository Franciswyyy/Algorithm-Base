package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length+1];

        for(int i = 0; i < nums.length; i ++){
            if(flag[nums[i]]){
                res.add(nums[i]);
            }else {
                flag[nums[i]] = true;
            }
        }
        return res;
    }


    public List<Integer> findDuplicates1(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            int index = Math.abs(nums[i]);
            if(nums[index-1] > 0) nums[index-1] = - nums[index-1];
            else    res.add(Math.abs(nums[i]));
        }
        return res;
    }
}
