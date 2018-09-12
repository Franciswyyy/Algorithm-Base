package LeetCode;

import java.util.HashMap;

public class Solution666 {

    public int pathSum(int[] nums) {

        if(nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num : nums) map.put(num/10, num%10);   // 百位->个位
        helper(nums[0]/10, map, 0, res);
        return res;
    }

    private void helper(int num, HashMap<Integer, Integer>map, int cur, int res){
        int level = num / 10, pos = num % 10;
        int left = (level+1)+2*pos-1, right = left+1;
        cur += map.get(num);
        if(!map.containsKey(left) && !map.containsKey(right)){
            res += cur;
            return;
        }
        if(map.containsKey(left)) helper(left, map, cur, res);
        if(map.containsKey(right)) helper(right, map, cur, res);
    }
}
