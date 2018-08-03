package LeetCode;

public class Solution080 {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for(int n : nums){
            if(i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        return i;
    }


    // 另一种

    public int remove(int[] nums){

        int index = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i-1] == nums[i]){
                if(count < 2){
                    nums[index++] = nums[i];
                    count++;
                }
            }else {
                count = 1;
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    //总结出两种为 k 的情况
    public int removeDuplicates01(int[] nums, int k){
        if(nums.length <= k) return nums.length;

        int i = 0;
        for(int n : nums){
            // 当然当k=0,就直接写i = 0 判断过去了
            if(n < k || n > nums[i-k])
                nums[i++]  = n;
        }
        return i;
    }

    public int removeDuplicates02(int[] nums, int k){

        if(nums.length <= k) return nums.length;

        int index = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i-1]){
                if(count < k){  //初始为1, k为2,只要加下就满了
                    count++;
                    nums[index++] = nums[i];
                }else {
                    count = 1;
                    nums[index++] = nums[i];
                }
            }
        }
        return index;
    }

}
