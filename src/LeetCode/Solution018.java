package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i = 0, len = nums.length-1; i < len-3; i ++){
            if(nums[i] << 2 > target) return res;   // 最小的2倍还大
            for(int j = len-1; j > i+2; j--){   // i j中间必须能放2个
                if(nums[j] << 2 < target) return res;  // 最大的2倍还小
                int rem = target - nums[i] - nums[j];
                // 接下来就是 i j中间的值了
                int lo = i + 1, hi = j - 1;
                while(lo < hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum > rem) -- hi;
                    else if(sum < rem) ++ lo;
                    else{
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                        while(++lo <= hi && nums[lo-1] == nums[lo]) continue;
                        while(--hi >= lo && nums[hi] == nums[hi+1]) continue;
                    }
                }
                while(j>=1 && nums[j] == nums[j--]) --j;
            }
            while(i<len-1 && nums[i] == nums[i+1]) ++i;
        }
        return res;
    }
}
