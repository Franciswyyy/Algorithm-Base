package LeetCode;

public class Solution070 {

    public int climbStairs(int n) {

        int[] memo = new int[n+1];

        memo[0] = 1;    // 没的走
        memo[1] = 1;

        for(int i = 2; i <= n; i ++){
            memo[n] = memo[n-1] + memo[n-2];
        }
        return memo[n];
    }
}
