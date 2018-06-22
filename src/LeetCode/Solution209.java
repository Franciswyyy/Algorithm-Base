package LeetCode;

public class Solution209 {

    // 暴力破解 O(n^3)
    public static int minSubArrayLen01(int s, int[] nums) {

        int res = nums.length + 1;
        for(int i = 0; i < nums.length; i ++){
            for(int j = i; j < nums.length; j ++ ){
                int sum = 0;
                for(int k = i; k <= j; k ++){
                    sum += nums[k];
                }
                if(sum >= s){
                    res = Math.min(res, j-i+1);
                }
            }
        }

        if(res == nums.length + 1)
            return 0;

        return res;
    }

    // 优化了 求和部分 O(n^2)
    public static int minSubArrayLen02(int s, int[] nums) {

        //sum[i]存放nums[0,,i-1]的和   0到各个位数的和，故要存的多一位
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i = 1; i <= nums.length; i ++){
            sums[i] = sums[i-1] + nums[i-1];
        }

        int res = nums.length + 1;
        for(int i = 0; i < nums.length; i ++){
            for(int j = i; j < nums.length; j ++){
                // 使用sums[j+1] - sums[i] 快速获得nums[i..j]的和
                if(sums[j+1] - sums[i] >= s)
                    res = Math.min(res, j - i + 1);
            }
        }
        if(res == nums.length + 1)
            return 0;

        return res;

    }


    // 滑动窗口  空间O(1)  时间O(n)
    public static int minSubArrayLen03(int s, int[] nums){

        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){

            if(r+1 < nums.length && sum < s){
                sum += nums[++ r];
            }else    // r已经到头了
                sum -= nums[l ++];

            if(sum >= s){
                res = Math.min(res, r - l + 1);
            }
        }
        if(res == nums.length +1) return 0;
        return res;
    }

    // 另一种滑动窗口实现，差不多~
    public static int minSubArrayLen04(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // [l...r]为我们的窗口
        int sum = 0;
        int res = nums.length + 1;

        while(r + 1 < nums.length){   // 窗口的右边界无法继续扩展了, 则循环继续

            while(r + 1 < nums.length && sum < s)
                sum += nums[++r];

            if(sum >= s)
                res = Math.min(res, r - l + 1);

            while(l < nums.length && sum >= s){
                sum -= nums[l++];
                if(sum >= s)
                    res = Math.min(res, r - l + 1);
            }
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen03(s, nums));
    }
}
