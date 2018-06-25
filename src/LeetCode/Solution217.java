package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <  nums.length; i ++){
            if(!set.add(nums[i])) return true;
        }
        return false;

    }
}

