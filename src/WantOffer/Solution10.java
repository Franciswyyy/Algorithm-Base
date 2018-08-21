package WantOffer;

// 旋转数组的最小数字
public class Solution10 {

    /**
     * 时间复杂度O(n)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i ++){
            if(array[i] < min) min = array[i];
        }
        return min;
    }

    /**
     * 有序的查找就考虑而二分查找时间复杂度O(lgn)
     * @param array
     * @return
     */
    public int minNumberInRotateArray01(int[] array){
        if(array == null || array.length == 0) return 0;

        int left = 0, right = array.length-1;
        int mid = 0;
        while(array[left] >= array[right]){
            if(right-left ==1){
                mid = right;
                break;
            }
            mid = left + (right - left)/2;
            if(array[mid] >= array[left]) left = mid;
            else  right = mid;
        }
        return array[mid];
    }
}
