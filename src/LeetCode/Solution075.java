package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 一个数组只有3个元素进行原地排序~   先解决问题，再去想优化
public class Solution075 {

    // 利用系统自带的排序，当然不是原地
    public void sortColors(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            list.add(nums[i]);
        }

        Collections.sort(list);

        for(int i = 0; i < nums.length; i ++){
            nums[i] = list.get(i);
        }
    }

    // 对于个数少的话，一般是计数排序,适用于元素个数非常有限的情况,O(k)--O(1)还能优化~
    public static void sortColorsOfSort(int[] nums){

        int[] count = {0,0,0};
        for(int i = 0; i < nums.length; i ++){
            count[nums[i]] ++;
        }

        int index = 0;
        for(int i = 0; i < count[0]; i ++){
            nums[index++] = 0;
        }
        for(int i = 0; i < count[1]; i ++){
            nums[index++] = 1;
        }
        for(int i = 0; i < count[2]; i ++){
            nums[index++] = 2;
        }

    }


    // 三路快速排序， 基本的
    public static void sortColorsOf3Ways(int[] nums){
        sort(nums, 0, nums.length-1);

    }
    private static void sort(int[] arr, int l, int r){
        if(r < l) return;

        int target = arr[l];

        int lt  = l;
        int gt = r + 1;
        int i = l + 1;
        while(i < gt){
            if(arr[i] < target){
                swap(arr, i, lt+1);
                lt ++;
                i ++;
            }else if(arr[i] > target){
                swap(arr, i, gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(arr, l, lt);

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    // 针对这道题的三路快排
    public static void sortColorsThree(int[] nums){

        int zero = -1;    //  [0....zero] == 0
        int two = nums.length;    // [two....n-1]==2
//        for(int i = 0; i < two; ){
        int i = 0;
        while(i < two){
            if(nums[i] == 1){
                i ++;
            }else if(nums[i] == 0){
                swap(nums, ++zero, i++);
            }else{  //  == 2
                swap(nums, --two, i);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};

        sortColorsThree(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "-");
        }
    }

}
