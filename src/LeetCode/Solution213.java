package LeetCode;


// 抢劫环形的街道
public class Solution213 {

    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private int rob(int[] nums, int lo, int hi){
        int preNo = 0;
        int preYes = 0;
        for(int i = lo; i <= hi; i ++){
            int temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = temp + nums[i];
        }
        return Math.max(preNo, preYes);
    }


}
