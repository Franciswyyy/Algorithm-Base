package LeetCode;

import java.util.Arrays;

public class Solution016 {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i + 2 < nums.length; i ++){
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(sum - target < 0){
                    lo++;
                }else if(sum - target > 0){
                    hi--;
                }else{
                    return target;
                }
            }
        }
        return res;
    }

}
