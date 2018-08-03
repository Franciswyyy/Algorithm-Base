package LeetCode;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return f(nums, mid);
            }else if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
    private int[] f(int[] arr, int mid){
        int i,j;
        i=j=mid;
        while(i >= 0 && arr[i]==arr[mid]){
            i--;
        }
        while (j < arr.length && arr[j] == arr[mid]){
            j++;
        }
        return new int[]{i+1, j-1};
    }
}
