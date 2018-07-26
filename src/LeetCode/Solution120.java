package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        return helper(triangle, 0, 0, 0, Integer.MAX_VALUE);
    }

    private int helper(List<List<Integer>> triangle, int level, int index, int cur, int min){

        cur += triangle.get(level).get(index);
        if(level == triangle.size() -1)
            return Math.min(min, cur);

        return Math.min(helper(triangle, level+1, index, cur, min),
                helper(triangle, level+1, index+1, cur, min));
    }


    // 动态规划
    public int minimumTotal1(List<List<Integer>> triangle){
        int[] dp = new int[triangle.size() + 1];

        for(int i = triangle.size()-1; i >= 0; i --){
            for(int j = 0; j <= i; j ++){
                int min = Math.min(dp[j],dp[j+1]);
                dp[j] = triangle.get(i).get(j) + min;
            }
        }
        return dp[0];
    }


}
