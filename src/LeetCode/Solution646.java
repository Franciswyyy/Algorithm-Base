package LeetCode;

import java.util.Arrays;

public class Solution646 {

    public int findLongestChain(int[][] pairs) {

        int len = pairs.length;

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i ++){
            for(int j = 0; j < i; j ++){
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < len; i ++){
            if(dp[i] > res)  res = dp[i];
        }
        return res;
    }
}
