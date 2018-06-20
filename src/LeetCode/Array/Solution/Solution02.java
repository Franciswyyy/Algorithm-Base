package LeetCode.Array.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {

    // 283题    原地
    public void moveZeroes(int[] nums) {

        int len = nums.length;
        int count = 0;  // 0的个数
        for(int i = 0; i < len; i ++){
            if(nums[i] == 0){
                count ++;
                continue;
            }
            nums[i-count] = nums[i];
        }

        len--;
        while(count!=0){
            nums[len--] = 0;
            count--;
        }
    }

    //283题  空间复杂度为O(n)
    public void moveZeroesOfList(int[] arr){

        List<Integer> nonZeroElements = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i ++){
            if(arr[i] != 0){
                nonZeroElements.add(arr[i]);
            }
        }

        for(int i = 0; i < nonZeroElements.size(); i ++){
            arr[i] = nonZeroElements.get(i);
        }

        for(int i = nonZeroElements.size(); i < arr.length; i ++){
            arr[i] = 0;
        }
    }

    //27题   删除数组中相同元素
    public int removeElement(int[] nums, int val) {

        int count = 0;  // 相同的个数
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == val){
                count++;
                continue;
            }
            nums[i-count] = nums[i];
        }
    /**/    return nums.length-count;
    }

    /**
     *  26题  对有序数组去重
     *  关键点不是等于前一个，就直接等于该位置上的数字，因为每个位置都是排好序且只能是一个
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length== 1) return 1;

        int position = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] != nums[position]) nums[++position] = nums[i];
        }
        return position+1;
    }

    // 80题 对有序数组去重II, 要去重复云元素最多有两个
    public static int removeDuplicatesII(int[] nums) {
        int i = 0;
        for(int n : nums){
            if(i < 2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }

    // 80题 有序数组去重II, 返回去重后数组的个数
    public static int removeDuplicate(int[] nums){
        if(nums.length < 2) return nums.length;
        int i, j;
        for(i = 2, j =2; i < nums.length; i ++){
            if(nums[j-2] != nums[i]) nums[j++] = nums[i];
        }
        return j;
    }

    // 扩充~  有序数组中去重，最多保留k个相同的
    public static int removeKDuplicate(int[] nums, int k){
        if(nums.length < k) return nums.length;
        int i, j;
        for(i = k, j = k; i < nums.length; i ++){
            if(nums[j-k] != nums[i]) nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,3,3,3,3,4,4,5,5,5,5,7,8,9,9,9};
        System.out.println(removeKDuplicate(arr, 3));
        for(int i = 0; i < 15; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
