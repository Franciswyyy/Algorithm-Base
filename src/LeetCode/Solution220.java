package LeetCode;

import java.util.Set;
import java.util.TreeSet;

public class Solution220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i ++){
            if(i > k) set.remove((long)nums[i-k-1]);    // 不强转就错了
            // if(i >= k) set.remove(nums[i-k]);

            long n = (long)nums[i];
            // 可能会没有
            Long floor = set.floor(n);
            Long ceil = set.ceiling(n);

            if((floor != null && n - floor <= t) ||
                    (ceil != null && ceil - n <= t)){
                return true;
            }

            set.add(n);
        }
        return false;
    }
}
