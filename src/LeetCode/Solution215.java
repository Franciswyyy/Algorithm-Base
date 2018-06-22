package LeetCode;

import java.util.Arrays;

public class Solution215 {

    //  简便方法  O(nlogn)
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int len = nums.length-1;
        int i = 1;
        while(i != k){
            i++;
            len--;
        }
        return nums[len];
    }

    // 最优  快排partition操作O(n)
    public static int findKthLargestPartiton(int[] nums, int k){
        int n = nums.length;
        int p = partition(nums, 0, n-1, n-k+1);
        return nums[p];
    }
    private static int partition(int[] a, int lo, int hi, int k){

        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        int m = i - lo + 1;          //计算  <= lo的个数
        if (m == k)     return i;
        else if (m > k) return partition(a, lo, i - 1, k);
        else            return partition(a, i + 1, hi, k - m);
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargestPartiton(arr, 1));
    }

}
