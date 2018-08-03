package LeetCode;

import java.util.HashSet;
import java.util.Iterator;

public class Solution136 {

    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                continue;
            }
            set.add(nums[i]);
        }
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            return iter.next();
        }
        return 0;
    }

    public int singleNumber1(int[] nums){
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
