package WantOffer;

public class Solution02 {

    /**
     * 当然用集合set找很简单， 但是空间复杂度为O(n)
     * 而用二分查找空间复杂度为O(1),而时间复杂度O(nlogn)
     * 缺点是不能完全找出重复的，可能只能找出一个，如果找全部的，这个方法不适合。
     * @param numbers
     * @param length
     * @return
     */
    public static int getDuplication(int[] numbers, int length){

        if(numbers == null || length <= 0) return -1;

        int start = 1;
        int end = length-1;
        while(start <= end){
            int mid = (end - start) >> 1 + start;
            int count = countRange(numbers, length, start, mid);
            // 就只剩下一个了
            if(end == start){
                if(count > 1) return start;
                else break;
            }
            if(count > (mid-start+1)) end = mid;
            else start = mid+1;
        }
        return -1;
    }
    private static int countRange(int[] numbers, int length, int start, int end){

        if(numbers == null) return 0;

        int count = 0;
        for(int i = 0; i < length; i ++){
            if(numbers[i] >= start && numbers[i] <= end)
                count++;
        }
        return count;
    }
}
