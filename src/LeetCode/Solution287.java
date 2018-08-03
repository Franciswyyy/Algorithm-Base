package LeetCode;

public class Solution287 {

    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }

        int point = 0;
        while(true){
            slow = nums[slow];
            point = nums[point];
            if(slow == point){
                return slow;
            }
        }
    }
}
