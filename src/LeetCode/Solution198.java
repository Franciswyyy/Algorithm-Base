package LeetCode;

import java.util.Arrays;

public class Solution198 {

    // 考虑抢劫nums[index....nums.length]这个范围的所有房子
    private int tryRob(int[] nums, int index, int[] memo){

        if(index >= nums.length)
            return 0;

        if(memo[index] != -1)
            return memo[index];

        int res = 0;
        for(int i = index; i < nums.length; i++){
            res = Math.max(res, nums[i] + tryRob(nums, i+2, memo));
        }
        memo[index] = res;
        return res;
    }

    public int rob(int[] nums) {

        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        return tryRob(nums, 0, memo);
    }


    public int rob1(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;

        //memo[i]表示考虑抢劫nums[i..n]所能获得的最大收益
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        memo[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i --){
            // memo[i]
            for(int j = i; j < n; j ++){
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j+2] : 0 ));
            }
        }
        return memo[0];
    }



    // 动态规划
    public int rob2(int[] nums){
        // 规定dp[i][0]不抢，dp[i][1]抢
        int[][] dp = new int[nums.length+1][2];
        for(int i = 1; i <= nums.length; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i-1] + dp[i-1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    //动态规划，简化空间
    public int rob3(int[] nums){
        int preNo = 0;
        int preYes = 0;
        for(int n : nums){
            int temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = temp + n;
        }
        return Math.max(preNo, preYes);
    }
}
