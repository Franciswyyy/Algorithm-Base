package LeetCode;

public class Solution011 {

    public int maxArea(int[] height) {

        int i = 0, j = height.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j){
            int high = Math.min(height[i], height[j]);
            int wide = j-i;

            maxArea = wide*high > maxArea ? wide * high : maxArea;

            if(height[i] > height[j]) j--;
            else i ++;
        }
        return maxArea;
    }
}
