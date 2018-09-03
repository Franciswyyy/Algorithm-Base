package WantOffer;

public class Solution37 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;

        int max = Integer.MIN_VALUE;    // 初始值不能设置为0，防止数组全是负数
        int curSum = 0;   // 当前最大值
        for(int i = 0; i < array.length; i ++){
            if(curSum <= 0){
                curSum = array[i];    // 当前累加是负数就直接不要
            }else {
                curSum += array[i];
            }
            max = Math.max(max, curSum);
        }
        return max;
    }


    public int FindGreatestSumOfSubArray01(int[] array) {
        if(array == null || array.length == 0) return 0;
        int res = array[0], tempSum = array[0];
        for(int i = 1; i < array.length; i ++){
            tempSum = (tempSum < 0) ? array[i] : tempSum + array[i];
            res = Math.max(res, tempSum);
        }
        return res;
    }
}
