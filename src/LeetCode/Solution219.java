package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution219 {

    // 优化后
    public boolean containsNearbyDuplicate(int[] nums, int k){

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){

            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }



    // 暴力破解
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;

        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j <nums.length; j ++){
                if(i == j) continue;

                if(nums[i] == nums[j] && Math.abs(j-i) <= k) return true;
            }
        }
        return false;
    }

}
