package LeetCode;

public class Solution026 {

    public int removeDuplicates(int[] nums) {

        if(nums.length < 2) return 1;

        int index = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] != nums[i-1])nums[index++] = nums[i];
        }
        return index;
    }


    public int removeDuplicates1(int[] nums) {

        int i = 0;
        for(int n : nums){
            if(i == 0 || nums[i-1] != n)
                nums[i++] = n;
        }
        return i;
    }
}
