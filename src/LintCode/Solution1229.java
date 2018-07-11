package LintCode;

import java.util.HashMap;
import java.util.Map;

public class Solution1229 {

    public boolean circularArrayLoop(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            map.put(i, (i + len+nums[i]%len) % len);
        }
        boolean[] res = new boolean[len];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(res[value]){
                return true;
            }
            res[value] = true;
        }
        return false;
    }

    public boolean circularArrayLoop1(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getIndex(int i, int[] nums){
        int len = nums.length;
        return (i + nums[i]) >= 0 ? (nums[i] + i) % len : (nums[i] + i) % len + len;   // 负数可能很大
    }


}
