package LeetCode;

import java.util.HashMap;

public class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i ++){
                if(map.containsKey(target - nums[i])){
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    return res;
                }
                map.put(nums[i], i);
        }
        return null;   // 因为题目已经保证了有唯一解
    }
}
