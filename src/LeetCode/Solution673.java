package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution673 {

    // 未做
    public static int findNumberOfLIS(int[] nums) {

        int len = nums.length, res = 0, max_len = 0;
        int[] dp = new int[len];
        int[] cnt = new int[len];

        for(int i = 0; i < len; i ++){
            dp[i] = cnt[i] = 1;
            for(int j = 0; j < i; j ++){

            }
        }
        return 1;
    }


    public static int findNumberOfLIS11(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int index = 0;
        for(int i = 1; i < len; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int[] cnt = new int[len];
        cnt[0] = 1;
        int max = cnt[0];
        for(int i = 1; i < len; i ++){
            for(int j = 0; j < i; j ++){
                if((dp[i] == dp[j] + 1) && nums[i] > nums[j]){
                    cnt[i] += cnt[j];
                    max = Math.max(max, cnt[i]);
                    continue;
                }
                cnt[i] = dp[i];
            }
        }
        int res = 0;
        for(int i = 0; i < len; i ++){
            if(cnt[i] == max) res += cnt[i];
        }
        return res;
    }

    public static void main(String[] args) {
          int[] num = new int[]{1,2,4,3,5,4,7,2};
//        int[] num = new int[]{2,2,2,2,2};
        System.out.println(findNumberOfLIS(num));
    }
}
