package LeetCode;

import java.util.*;

public class Solution015 {


    // 以第一个i为起始，一定要注意重复的结果怎么避免，
    // 当已经确定了，那么其后一样的值就不考虑了，  当i已经一样时，如果前面已经有一样的了，照样不考虑
    // 一个前，一个后
    public static List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {         //避免重复的结果
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }



    // 错误
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;
        if(nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length-1;
        int k = j - 1;
        while(i < j && k < j){
            if(nums[i] + nums[j] + nums[k] > 0 ){
                k -- ;
            }

            if(nums[i] + nums[j] + nums[k] < 0){
                i ++;
            }
            if(nums[i] + nums[j] + nums[k] == 0){
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                res.add(list);
                j--;
                k = j;
                i = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(arr);
        Iterator iter = res.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
