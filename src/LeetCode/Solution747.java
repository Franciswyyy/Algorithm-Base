package LeetCode;

public class Solution747 {


    // 求一个数组中最大的数是其他数至少两倍大  easy?  方法每用对? 没错，就是这么写的~
    public int dominantIndex(int[] nums) {

        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < nums.length; i ++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] * 2 <= max){
                continue;
            }
            count ++;
        }
        return count == 1 ? index : -1;
    }



    public int dominantIndex1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < nums.length; i ++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }

        for(int i = 0; i < nums.length; i ++){
            if(i == index) continue;
            else{
                if(max < nums[i]*2) return -1;
            }
        }
        return index;
    }


}
