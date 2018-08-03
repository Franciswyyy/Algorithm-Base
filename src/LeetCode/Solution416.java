package LeetCode;

public class Solution416 {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % 2 ==  0) sum = sum/2;
        else return false;

        int[][] dp = helper(nums, sum);
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                if(dp[i][j] == sum) return true;
            }
        }

        return false;
    }

    private int[][] helper(int[]w, int c){
        int n = w.length;
        int[][] dp = new int[n][c+1];

        for(int i = 0; i <= c; i ++)
            dp[0][i] = (i >= w[0] ? w[0] : 0);

        for(int i = 1; i < n; i ++){
            for(int j = 0; j <= c; j ++){
                dp[i][j] = dp[i-1][j];
                if(j >= w[i])
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-w[i]] + w[i]);
            }
        }

        return dp;
    }
}
