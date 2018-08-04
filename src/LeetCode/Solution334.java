package LeetCode;

import java.util.Arrays;

public class Solution334 {

    public boolean increasingTriplet(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        for(int i = 0; i < len; i ++){
            if(dp[i] >= 3)
                return true;
        }
        return false;
    }
}
